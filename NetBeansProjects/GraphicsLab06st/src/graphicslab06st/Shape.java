/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab06st;

import java.awt.Graphics;

/**
 *
 * @author Carter
 */
interface Shape {
    public abstract void drawShape(Graphics g);
    public abstract void displayName(Graphics g);
    public abstract void displayNumSides(Graphics g);
}
