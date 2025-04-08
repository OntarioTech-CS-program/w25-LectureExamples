import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RockPaperScissorsClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 5000;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JFrame frame;
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel statusLabel;
    private JLabel playerLabel;
    private String playerID;

    public RockPaperScissorsClient() {
        frame = new JFrame("Rock Paper Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        playerLabel = new JLabel("Connecting...", SwingConstants.CENTER);
        statusLabel = new JLabel("Waiting for server response...", SwingConstants.CENTER);
        frame.add(playerLabel, BorderLayout.NORTH);
        frame.add(statusLabel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        frame.add(buttonPanel, BorderLayout.CENTER);

        rockButton.addActionListener(e -> sendChoice("Rock"));
        paperButton.addActionListener(e -> sendChoice("Paper"));
        scissorsButton.addActionListener(e -> sendChoice("Scissors"));

        disableButtons(); // Disable buttons initially until both players connect
        frame.setVisible(true);
        //        connect to the server
        connectToServer();
    }

    private void connectToServer() {
        try {
            System.out.println("Connecting to " + SERVER_ADDRESS + ":" + PORT);
            socket = new Socket(SERVER_ADDRESS, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // listening for the server input
            new Thread(this::listenForServerMessages).start();
        } catch (IOException e) {
            statusLabel.setText("Error connecting to server:"+ SERVER_ADDRESS + ":" + PORT);
        }
    }

    private void sendChoice(String choice) {
        out.println(choice);
        disableButtons();
        statusLabel.setText("Waiting for opponent...");
    }

    private void disableButtons() {
        rockButton.setEnabled(false);
        paperButton.setEnabled(false);
        scissorsButton.setEnabled(false);
    }

    private void enableButtons() {
        rockButton.setEnabled(true);
        paperButton.setEnabled(true);
        scissorsButton.setEnabled(true);
    }

    private void listenForServerMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                final String finalMessage = message;
                SwingUtilities.invokeLater(() -> {
                    if (finalMessage.startsWith("ID")) {
                    // TODO: set playerLabel and statusLabel
                        playerID = finalMessage.split(" ")[1];
                        playerLabel.setText("You are Player "+playerID+".");
                        statusLabel.setText("Waiting for second player.");
                    } else if (finalMessage.equals("Both players connected. Make your move: Rock, Paper, or Scissors")) {
                        statusLabel.setText("Make your move!");
                        enableButtons();
                    } else {
                        // TODO: decide on the outcome of the game, display JOptionPane, ready to play again
                        statusLabel.setText(finalMessage);
                        if(finalMessage.contains("wins") || finalMessage.contains("tie")) {
                            if (finalMessage.contains(playerID)){
                                JOptionPane.showMessageDialog(frame, "You win!");
                            }else{
                                JOptionPane.showMessageDialog(frame, finalMessage);
                            }
                        }


                    }
                });
            }
        } catch (IOException e) {
            SwingUtilities.invokeLater(() -> statusLabel.setText("Connection lost."));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RockPaperScissorsClient::new);
    }
}

