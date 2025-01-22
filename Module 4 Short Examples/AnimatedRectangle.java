import javax.swing.*;
import java.awt.*;

public class AnimatedRectangle extends Canvas {

    private int x = 0; // Initial x position
    private int y = 100; // Fixed y position

    public AnimatedRectangle() {
        Timer timer = new Timer(10, e -> {
            x += 2; // Move the rectangle
            if (x > getWidth()) {
                x = -50; // Reset position once it moves out of view
            }
            repaint(); // Request a redraw of the canvas
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50); // Draw the rectangle
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Rectangle");
        AnimatedRectangle canvas = new AnimatedRectangle();
        canvas.setSize(400, 300);

        frame.add(canvas);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
