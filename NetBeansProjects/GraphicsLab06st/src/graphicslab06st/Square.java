/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab06st;

import java.awt.Graphics;

class Square extends AbstractShape{

    protected Square(int ns, String sn, int tx, int ty, int mx, int my) {
        super(ns, sn, tx, ty, mx, my);
    }
    
    
    
    public void drawShape(Graphics g) {
        g.fillRect(105, 90, 150, 150);
    }

    public void displayNumSides(Graphics g) {
        g.drawString("A " + shapeName + " has " + numSides + " sides.", messageX, messageY);
    }

    public void displayName(Graphics g) {
        g.drawString(shapeName, titleX, titleY);
    }

    
    
}
