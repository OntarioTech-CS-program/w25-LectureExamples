import javax.swing.*;
import java.awt.*;

public class ChatView extends JFrame {
    private final JTextArea chatArea;
    private final JTextField inputField;
    private final JButton sendButton;

    public ChatView() {
        // Setup the frame
        this.setTitle("Chat App");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // TODO: Chat display area - CENTER with JScrollPane
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		this.add(new JScrollPane (chatArea), BorderLayout.CENTER);


        // TODO: Input panel (PAGE_END) - CENTER for inputField and LINE_END for sendButton
        JPanel inputPanel = new JPanel(new BorderLayout());
		inputField = new JTextField();
		sendButton = new JButton("Send");
		inputPanel.add(inputField, BorderLayout.CENTER);
		inputPanel.add(sendButton, BorderLayout.LINE_END);
		
		this.add(inputPanel, BorderLayout.PAGE_END);


    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JButton getSendButton() {
        return sendButton;
    }
}
