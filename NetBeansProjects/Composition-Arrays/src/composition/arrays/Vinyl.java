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
class Vinyl {
	private String band;
	private double cost;

	public Vinyl(String band, double cost)
	{
		this.band = band;
		this.cost = cost;
	}

	public void printVinyl()
	{
		System.out.println("Band Name: " + band);
		System.out.println("Cost:  " + cost);
	}
}