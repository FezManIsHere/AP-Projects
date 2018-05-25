package graphicslab05st;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class Circles {

    private int circleCount;
    private Random rnd;
    int red, green, blue;
    int rx = 60, gx = 60, bx= 60;
    int ry = 105, gy = 255, by = 405;
    //^^ Initial values needed to draw the circles
    
    private int redCount, greenCount, blueCount;

    public Circles(Graphics g, int c) {
        rnd = new Random(12345);
        circleCount = c;
        redCount = 0;
        greenCount = 0;
        blueCount = 0;
        drawSquares(g);
        for (int k = 1; k <= circleCount; k++) {
            drawRandomCircle(g);
        }
    }

    public void drawSquares(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(10, 100, 30, 30);
        g.setColor(Color.green);
        g.fillRect(10, 250, 30, 30);
        g.setColor(Color.blue);
        g.fillRect(10, 400, 30, 30);
    }

    //Draws the circle, using a random Color
    public void drawRandomCircle(Graphics g) {
        Color hi = getRandomColor();
        if (red > green && red > blue) {
            if (redCount >= 17) {
                ry = 135;
            }
            g.setColor(hi);
            g.fillOval(rx, ry, 20, 20);
            rx+=40;
            redCount++;
        //^^ Creates a circle in the correct location
            if (redCount == 17) {
                rx = 60;
            }
            //^^ Resets the x value when the top row is full
        } else if (green > blue && green > red) {
            if (greenCount >= 17) {
                gy = 285;
            }
            g.setColor(hi);
            g.fillOval(gx, gy, 20, 20);
            gx+=40;
            greenCount++;
            //^^ Creates a circle in the correct location
            if (greenCount == 17) {
                gx = 60;
                //^^ Resets the x value when the top row is full
            }
        } else if(blue > red && blue > green) {
            if (blueCount >= 17) {
                by = 435;
            }
            g.setColor(hi);
            g.fillOval(bx, by, 20, 20);
            bx+=40;
            blueCount++;
            //^^ Creates a circle in the correct location
            if (blueCount == 17) {
                bx= 60;
                //^^ Resets the x value when the top row is full
            }
        }
        

    }

    //Creates a Color with random RGB values
    public Color getRandomColor() {
        red = rnd.nextInt(256);
        green = rnd.nextInt(256);
        blue = rnd.nextInt(256);
        return new Color(red, green, blue);
    }
}
