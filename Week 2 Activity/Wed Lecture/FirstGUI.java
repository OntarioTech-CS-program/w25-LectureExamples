import javax.swing.*;
import java.awt.*;

public class FirstGUI{
	public static void main(String[] args){
		// Creating our window
		JFrame frame = new JFrame("My First Swing App");
		frame.setLayout(new FlowLayout());
		
		// indicate that the app should hault if window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ---- creating UI objects
		// create a button
		JButton button = new JButton("Click to print");
		// create textfield
		JTextField textField = new JTextField(20);
		JLabel outputLabel = new JLabel("Placeholder");
		
		
		
		
		// add the printing when button is clicked
		// button.addActionListener(e -> System.out.println("Clicked"));
		button.addActionListener(e -> {
			String inputText = textField.getText();
			//System.out.println(inputText);
			if (inputText.isEmpty()){
				// show error dialog
				JOptionPane.showMessageDialog(frame, "Your input should not be empty!!!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				// update the output label
				outputLabel.setText("You entered: " + inputText);
			}
		});
		
		// adjust button size x axis, y axis, width, height
		button.setBounds(50, 50, 120, 50);
		
		// remove layout managers
		//frame.setLayout(null);
		
		// ---- adding components to window
		// adding the button to the window
		frame.add(button);
		frame.add(textField);
		frame.add(outputLabel);
		
		// Setting size to the window
		frame.setSize(300,200);
		
		// display the window
		frame.setVisible(true);
		System.out.println("Hello World");
	}
}