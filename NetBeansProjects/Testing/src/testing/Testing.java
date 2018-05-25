/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author Carter
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        System.out.println(testMe("a"));
        
    }
    
    
    public static int testMe(String str) {
        int i = str.compareTo("c");
    return i;
    }
    }
