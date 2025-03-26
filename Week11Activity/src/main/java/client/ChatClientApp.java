package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClientApp {
    private static Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static JTextArea textArea;
    private static JTextField textField;
    private static String username;

    public static void main(String[] args) {
        try {
            // Get username from user through a popup window
            username = JOptionPane.showInputDialog("Enter your username:");

            socket = new Socket("localhost", 5000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Send username to server
            out.println(username);

            JFrame frame = new JFrame(username+"'s Chat Client");
            textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            JScrollPane scrollPane = new JScrollPane(textArea);

            textField = new JTextField();
            JButton sendButton = new JButton("Send");

            // Send message when user presses Enter or clicks the Send button
            textField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage();
                }
            });

            sendButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage();
                }
            });

            frame.setLayout(new BorderLayout());
            frame.add(scrollPane, BorderLayout.CENTER);
            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new BorderLayout());
            bottomPanel.add(textField, BorderLayout.CENTER);
            bottomPanel.add(sendButton, BorderLayout.EAST);
            frame.add(bottomPanel, BorderLayout.SOUTH);

            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            // Ensure proper closure of socket when window is closed
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    try {
                        // Close the socket and any resources
                        if (socket != null && !socket.isClosed()) {
                            socket.close();  // Close the socket when the window is closed
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            // Listen for incoming messages from the server in a background thread
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String message;
                        while ((message = in.readLine()) != null) {
                            textArea.append(message + "\n");
                        }
                    } catch (IOException e) {
                        // Handle socket closure and any input/output errors
                        if (!socket.isClosed()) {
                            e.printStackTrace();
                        }
                    } finally {
                        // Ensure proper socket closure if an exception occurs
                        try {
                            if (socket != null && !socket.isClosed()) {
                                socket.close();
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to send a message
    private static void sendMessage() {
        String message = textField.getText();
        if (!message.trim().isEmpty()) {
            out.println(message);  // Send the message to the server
            textField.setText("");  // Clear the text field after sending
        }
    }
}

