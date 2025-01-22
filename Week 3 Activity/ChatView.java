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

        // Chat display area - CENTER with JScrollPane
        chatArea = new JTextArea();
        chatArea.setEditable(false); // Make chatArea read-only
        chatArea.setLineWrap(true); // Wrap lines for better readability
        chatArea.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(chatArea);
        this.add(scrollPane, BorderLayout.CENTER);

        // Input panel (PAGE_END) - CENTER for inputField and LINE_END for sendButton
        inputField = new JTextField();
        sendButton = new JButton("Send");
        JPanel inputPanel = new JPanel(new BorderLayout());
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
