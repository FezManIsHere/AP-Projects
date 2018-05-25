/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab06st;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Carter
 */
class Windows extends Frame
{

	public void paint(Graphics g)
	{
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Square(4, "Square", 150, 50, 100, 290));
		shapes.add(new Triangle(3, "Triange", 550, 50, 500, 290));
		shapes.add(new Octagon(8, "Octagon", 150, 325, 100, 590));
		shapes.add(new Circle(0, "Circle", 550, 325, 500, 590));

		drawGrid(g);

		for(Shape shape: shapes)
		{
			shape.drawShape(g);
			shape.displayName(g);
			shape.displayNumSides(g);
		}
	}

	public void drawGrid(Graphics g)
	{
		g.drawLine(0,300,800,300);
		g.drawLine(400,0,400,600);
	}
}