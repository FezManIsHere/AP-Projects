/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab06st;

import java.awt.Graphics;

class Triangle extends AbstractShape{

    protected Triangle(int ns, String sn, int tx, int ty, int mx, int my) {
        super(ns, sn, tx, ty, mx, my);
    }

    
    
    public void drawShape(Graphics g) {
        g.fillPolygon(new int[] {575, 500, 650}, new int[] {75, 250, 250}, 3);
    }

    public void displayNumSides(Graphics g) {
        g.drawString("A " + shapeName + " has " + numSides + " sides.", messageX, messageY);
    }

    public void displayName(Graphics g) {
        g.drawString(shapeName, titleX, titleY);
    }
    
}
