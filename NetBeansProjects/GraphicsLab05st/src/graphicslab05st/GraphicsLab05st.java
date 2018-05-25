package graphicslab05st;

// GraphicsLab05st.java
// This is the student, starting version of the GraphicsLab05 assignment.


import java.awt.*;
import java.applet.*;
import java.util.*;


public class GraphicsLab05st extends Applet
{
	public void paint(Graphics g)
	{
		int circleCount = 100;
		Circles circles = new Circles(g,circleCount);
	}
}