/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composition.arrays;

import java.util.ArrayList;

/**
 *
 * @author Carter
 */
class MusicShop {
    
	private ArrayList<Vinyl> vinyls;

	public MusicShop()
	{
		vinyls = new ArrayList<Vinyl>();
	}

	public void loadData(String[] bands, double[] cost)
	{
		for (int k = 0; k < bands.length; k++)
		{
			Vinyl temp = new Vinyl(bands[k], cost[k]);
			vinyls.add(temp);
		}
	}

	public void printStudents()
	{
		for (Vinyl s: vinyls)
			s.printVinyl();
	}
}
