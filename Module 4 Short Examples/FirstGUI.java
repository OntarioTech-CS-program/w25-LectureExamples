import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstGUI {
    public static void main(String[] args) {
        // Create a new JFrame (the main window)
        JFrame frame = new JFrame("My First Swing App");
        
        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a button
        JButton button = new JButton("Click Me!");
        
        // Add an action listener to the button
        button.addActionListener(e -> System.out.println("Button clicked!"));
        
        // Add the button to the frame
        frame.add(button);
        
        // Set the frame size
        frame.setSize(300, 200);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}
