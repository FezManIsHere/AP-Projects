package graphicslab06st;

// GraphicsLab06st.java
// The Polymorphic Graphics Shapes Program
// Student, starting Version


import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;


public class GraphicsLab06st
{
	public static void main(String args[])
	{
		Windows win = new Windows();
		win.setSize(800,600);
		win.addWindowListener(new WindowAdapter() {public void
		windowClosing(WindowEvent e) {System.exit(0);}});
		win.show();
	}
}