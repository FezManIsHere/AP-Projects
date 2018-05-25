/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab06st;

/**
 *
 * @author Carter
 */
public abstract class AbstractShape implements Shape {
    protected int numSides;
    protected String shapeName;
    protected int titleX, titleY;
    protected int messageX, messageY;
    
    protected AbstractShape(int ns, String sn, int tx, int ty, int mx, int my) {
        numSides = ns;
        shapeName = sn;
        titleX = tx;
        titleY = ty;
        messageX = mx;
        messageY = my;
    }
    
    public void displayName() {
        
    }
    public void displayNumSides() {
        
    }
}
