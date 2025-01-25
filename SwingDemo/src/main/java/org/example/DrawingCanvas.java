package org.example;

import java.awt.*;

public class DrawingCanvas extends Canvas {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.white);

        // draw rectangle
        g.fillRect(250, 50, 100, 60);

        // Draw a circle
        g.setColor(Color.RED);
        g.fillOval(150, 50, 50, 50);

        // Draw a line
        g.setColor(Color.BLACK);
        g.drawLine(50, 150, 250, 150);

        // Draw some text
        g.setColor(Color.GREEN);
        g.drawString("Custom Drawing Example", 100, 200);
    }
}
