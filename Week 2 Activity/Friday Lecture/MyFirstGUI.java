import javax.swing.*;
import java.awt.*;

public class MyFirstGUI{
	
	public static void main(String[] args){
		JFrame frame = new JFrame("My First Swing App");
		frame.setLayout(new FlowLayout());
		
		// setting the app to stop running when x is clicked
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// creating a button
		JButton button = new JButton("Click to show");
		// setBounds x axis, y axis, width, length
		button.setBounds(50, 50, 100, 50);
		
		// creating the text input
		JTextField inputText = new JTextField(20);
		
		// creating the label
		JLabel outputText = new JLabel("Show here");
		
		// add action listener to button
		// button.addActionListener(e -> System.out.println("Clicked"));
		button.addActionListener(e -> {
				
				String text = inputText.getText();
				if (text.isEmpty()){
					// show error dialog
					JOptionPane.showMessageDialog(frame, "Text should not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					outputText.setText("You entered: "+text);	
				}
				
				
				//System.out.println(text);
			});
		
		//adding UI components to Frame
		frame.add(inputText);
		frame.add(button);
		frame.add(outputText);
		
		// set the size of frame
		frame.setSize(300, 200);
		
		// removing layout manager
		// frame.setLayout(null);
		
		// show the window
		frame.setVisible(true);
		
		
		System.out.println("Hello World");
	}
}