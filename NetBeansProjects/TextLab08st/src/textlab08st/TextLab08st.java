package textlab08st;

import java.util.ArrayList;

public class TextLab08st {
    
    public static void main(String args[]) {
        System.out.println("\nTextLab08 STUDENT VERSION\n");
        Matrix m1 = new Matrix();
        m1.displayMatrix("Matrix m1 Default Display");
        System.out.println();
        
        Matrix m2 = new Matrix(3, 5);
        int count = 100;
        for (int r = 0; r < m2.getRows(); r++) {
            for (int c = 0; c < m2.getCols(); c++) {
                m2.setValue(r, c, new Integer(count));
                count++;
            }
        }
        m2.displayMatrix("Matrix m2 3 X 5 Consecutive Integers Display");
        System.out.println();
        
        m2.resize(4, 4);
        m2.displayMatrix("Matrix m2 After 4 X 4 Resizing Display");
        System.out.println();
        
        Matrix m3 = new Matrix(3, 3, new Integer(100));
        m3.displayMatrix("Matrix m3 3 X 3 Initialized to 100 Display");
        System.out.println();
    }
}

class Matrix {
    
    private ArrayList list; // one-dimensional array stores matrix values
    private int listSize; // total number of elements in the matrix
    private int numRows; // number of rows in the matrix
    private int numCols; // number of cols in the matrix

    /**
     * Constructs empty ArrayList object and sets all values to 0 *
     */
    public Matrix() {
        listSize = 0;
        numRows = 0;
        numCols = 0;
        list = new ArrayList();
    }

    /**
     * Constructs r X c matrix with all elements initialized to 0 *
     */
    public Matrix(int r, int c) {
        list = new ArrayList();
        numRows = r;
        numCols = c;
        listSize = r * c;
        for (int i = 0; i < listSize; i++) {
            list.add(new Integer(0));
        }
    }

    /**
     * Constructs r X c matrix will all elements initialized to value *
     */
    public Matrix(int r, int c, int value) {
        list = new ArrayList();
        numRows = r;
        numCols = c;
        listSize = r * c;
        for (int i = 0; i < listSize; i++) {
            list.add(new Integer(value));
        }
    }

    /**
     * Returns numRows value *
     */
    public int getRows() {
        return numRows;
    }

    /**
     * Returns numCols value *
     */
    public int getCols() {
        return numCols;
    }

    /**
     * Returns listSize value *
     */
    public int getSize() {
        return listSize;
    }

    /**
     * Returns Matrix object value at (r,c) location *
     */
    public int getValue(int r, int c) {
        Integer temp = (Integer) list.get(r * numCols + c);
        return temp.intValue();
    }

    /**
     * Alters Matrix object value at (r,c) to value *
     */
    public void setValue(int r, int c, int value) {
        list.set(r * numCols + c, new Integer(value));
    }

    /**
     * Displays Matrix object in two-dimensional matrix format *
     */
    public void displayMatrix(String str) {
        System.out.println(str);
        if (listSize == 0) {
            System.out.println("Matrix has no elements");
        } else {
            for (int r = 0; r < numRows; r++) {
                for (int c = 0; c < numCols; c++) {
                    System.out.print(getValue(r, c) + " ");
                }
                System.out.println();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            
            System.out.println(list.get(i));
        }
    }

    /**
     * Resizes Matrix object to new rows X cols size, copies all possible
     * previous values and initializes new elements to zero *
     */
    public void resize(int rows, int cols) {
    }
}
