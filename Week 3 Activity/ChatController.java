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
                // TODO:send message
            }
        });

        // Add Enter key functionality
        view.getInputField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO:send message
            }
        });
    }

    private void sendMessage() {
        // TODO
    }

    public static void main(String[] args) {
        // Create MVC components
        ChatModel model = new ChatModel();
        ChatView view = new ChatView();

	// TODO: Create controller

        // Make the GUI visible
        view.setVisible(true);
    }
}
