/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composition.arrays;

/**
 *
 * @author Carter
 */
public class CompositionArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
		System.out.println("\nJAVA1213\n");

		String[] bands = 							
		      {"Metallica","Justin Beiber","Beatles","Billy Joel","Bob Dylan","Eminem"};

		double[] cost = {50.67, 34.56, 12.34, 78.45, 72.19, 62.98};

		MusicShop EclecticFinds = new MusicShop();
		 EclecticFinds.loadData(bands,cost);
		 EclecticFinds.printStudents();
		System.out.println();
    }
    
}
