import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatController {
    private final ChatModel model;
    private final ChatView view;

    public ChatController(ChatModel model, ChatView view) {
        this.model = model;
        this.view = view;

        // Add action listener to the send button
        view.getSendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Add Enter key functionality
        view.getInputField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = view.getInputField().getText().trim();
        if (!message.isEmpty()) {
            model.addMessage(message); // Add message to the model
            view.updateChatArea(message); // Update the chat area in the view
            view.getInputField().setText(""); // Clear the input field
        }
    }

    public static void main(String[] args) {
        // Create MVC components
        ChatModel model = new ChatModel();
        ChatView view = new ChatView();

        // Create controller
        new ChatController(model, view);

        // Make the GUI visible
        view.setVisible(true);
    }
}
