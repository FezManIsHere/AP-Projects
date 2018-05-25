/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textlab11st;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Carter
 */
class List {

    private Person student[]; // stores array elements private int capacity; 
    private int capacity; // actual array capacity private int size; 
    private int size; // number of elements in the array 

    public List(int c) {
        capacity = c;
        size = 0;
        student = new Person[capacity];
    }

    public void getList() throws IOException {
        FileReader inFile = new FileReader("student.dat");
        BufferedReader inStream = new BufferedReader(inFile);
        String s1, s2, s3, s4;
        int age, id;
        double gpa;
        int index = 0;
        while (((s1 = inStream.readLine()) != null) && ((s2 = inStream.readLine()) != null) && ((s3 = inStream.readLine()) != null) && ((s4 = inStream.readLine()) != null)) {
            String name = s1;
            id = Integer.parseInt(s2);
            age = Integer.parseInt(s3);
            gpa = Double.parseDouble(s4);
            student[index] = new Person(name, id, age, gpa);
            index++;
        }
        inStream.close();
        size = index;
    }

    private String spaces(String name) {
        int tab = 24 - name.length();
        String temp = "";
        for (int j = 1; j <= tab; j++) {
            temp += " ";
        }
        return temp;
    }

    public void display(String listInfo) {
        DecimalFormat output = new DecimalFormat("0.000");
        System.out.println("\nDISPLAYING " + listInfo);
        System.out.println("\nStudent ID# Student Name Age GPA");
        System.out.println("============================================================");
        for (int k = 0; k < size; k++) {
            System.out.println(student[k].id + " " + student[k].name + spaces(student[k].name) + student[k].age + " " + output.format(student[k].gpa));
        }
    }

    public void pause() {
        Scanner input = new Scanner(System.in);
        String dummy;
        System.out.println("\nPress <Enter> to continue.");
        dummy = input.nextLine();
    }

    public void displayStudent(int index) {
        DecimalFormat output = new DecimalFormat("0.000");
        //for (int k = 0; k < size; k++) {
        //    System.out.println(student[k].id + " " + student[k].name + spaces(student[k].name) + student[k].age + " " + output.format(student[k].gpa));
        //}
        //System.out.println(student[index].id + " " + student[index].name + spaces(student[index].name) + student[index].age + " " + output.format(student[index].gpa));
        System.out.println("Name " + student[index].name);
        System.out.println("Age " + student[index].age);
        System.out.println("GPA " + student[index].gpa);
    }

    private void swap(int x, int y) {
        Person temp = student[x];
        student[x] = student[y];
        student[y] = temp;
    }

    public void gpaSort() {
        int p, q;
        int smallest;
        for (p = 0; p < size - 1; p++) {
            smallest = p;
            for (q = p + 1; q < size; q++) {
                if (student[q].gpa < student[smallest].gpa) {
                    smallest = q;
                }
            }
            if (student[p].gpa != student[smallest].gpa) {
                swap(p, smallest);
            }
        }
    }

    public void ageSort() {
        int p, q;
        int smallest;
        for (p = 0; p < size - 1; p++) {
            smallest = p;
            for (q = p + 1; q < size; q++) {
                if (student[q].age < student[smallest].age) {
                    smallest = q;
                }
            }
            if (student[p].age != student[smallest].age) {
                swap(p, smallest);
            }
        }
    }

    public void idSort() {
        int p, q;
        int smallest;
        for (p = 0; p < size - 1; p++) {
            smallest = p;
            for (q = p + 1; q < size; q++) {
                if (student[q].id < student[smallest].id) {
                    smallest = q;
                }
            }
            if (student[p].id != student[smallest].id) {
                swap(p, smallest);
            }
        }
    }

    public int search(int studentID) {
//        boolean found = false;
//        int stuid = 0;
//       int k = 0;
//       while (k < size && !found)
//       {
//	if (student[k].id == studentID){
//	       found = true;
//               stuid = k;}
//	else
//	       k++;
//       }
//       
//        return stuid;

        boolean found = false;
        int lo = 0;
        int hi = size - 1;
        int mid = 0;
        while (lo <= hi && !found) {
            mid = (lo + hi) / 2;
            if (student[mid].id == studentID) {
                found = true;
            } else if (studentID > student[mid].id) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (found) {
            return mid;
        } else {
            return -1;
        }
    }

    public void delete(int index) {
        System.arraycopy(student, index + 1, student, index, student.length - 1 - index);
        size--;

// Precondition: "index" stores the index of a student object that exists in the "student" array.
// Postcondition: The student object at index "index" is removed from the "student" array.
// All other objects in the "student" array are unaffected.
    }
}
