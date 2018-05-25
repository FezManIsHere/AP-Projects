/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab06st;

import java.awt.Graphics;

class Octagon extends AbstractShape{

    protected Octagon(int ns, String sn, int tx, int ty, int mx, int my) {
        super(ns, sn, tx, ty, mx, my);
    }
    
    public void drawShape(Graphics g) {
        g.fillPolygon(new int[] {150, 215, 261, 261, 215, 150, 104, 104}, new int[] {370, 370, 416, 481, 527, 527, 481, 416}, 8);
    }

    public void displayNumSides(Graphics g) {
        g.drawString("An " + shapeName + " has " + numSides + " sides.", messageX, messageY);
    }

    public void displayName(Graphics g) {
        g.drawString(shapeName, titleX, titleY);
    }
    
}
