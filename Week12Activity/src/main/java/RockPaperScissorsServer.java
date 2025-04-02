import java.io.*;
import java.net.*;
import java.util.concurrent.locks.*;

class RockPaperScissorsServer {
    private static final int PORT = 5000;
    private Socket player1Socket, player2Socket;
    private BufferedReader in1, in2;
    private PrintWriter out1, out2;
    private String choice1, choice2;
    private final Object lock = new Object();

    public static void main(String[] args) {
        new RockPaperScissorsServer().startServer();
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started PORT "+PORT+". Waiting for players...");

            player1Socket = serverSocket.accept();
            System.out.println("Player 1 connected");
            out1 = new PrintWriter(player1Socket.getOutputStream(), true);
            in1 = new BufferedReader(new InputStreamReader(player1Socket.getInputStream()));
            out1.println("ID 1");

            player2Socket = serverSocket.accept();
            System.out.println("Player 2 connected");
            out2 = new PrintWriter(player2Socket.getOutputStream(), true);
            in2 = new BufferedReader(new InputStreamReader(player2Socket.getInputStream()));
            out2.println("ID 2");

            out1.println("Both players connected. Make your move: Rock, Paper, or Scissors");
            out2.println("Both players connected. Make your move: Rock, Paper, or Scissors");

            new Thread(() -> handlePlayer(in1, out1, 1)).start();
            new Thread(() -> handlePlayer(in2, out2, 2)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handlePlayer(BufferedReader in, PrintWriter out, int playerNumber) {
        try {
            while (true) {
                String choice = in.readLine();
                // TODO: set choices 1 and 2, have them know; if both chose, determine and broadcast winners


                // resetting the game after announcing the outcome of the match
                choice1 = null;
                choice2 = null;
                out1.println("Both players connected. Make your move: Rock, Paper, or Scissors");
                out2.println("Both players connected. Make your move: Rock, Paper, or Scissors");

            }
        } catch (IOException e) {
            out.println("Connection lost.");
        }
    }

    private String determineWinner() {
        if (choice1.equals(choice2)) {
            return "It's a tie!";
        } else if ((choice1.equals("Rock") && choice2.equals("Scissors")) ||
                (choice1.equals("Scissors") && choice2.equals("Paper")) ||
                (choice1.equals("Paper") && choice2.equals("Rock"))) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }
}