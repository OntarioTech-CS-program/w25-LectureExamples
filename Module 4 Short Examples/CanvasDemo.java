import javax.swing.*;
import java.awt.*;

public class CanvasDemo extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100); // Draw a red square
        g.setColor(Color.BLUE);
        g.fillOval(200, 50, 100, 100); // Draw a blue circle
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Graphics Example");
        CanvasDemo canvas = new CanvasDemo();
        frame.add(canvas);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}