import java.io.*;
import java.net.*;

public class ChatClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader userInput;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        System.out.println("Connected to server!");
        
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        userInput = new BufferedReader(new InputStreamReader(System.in));
        
        Thread receiveThread = new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Server: " + message);
                    if ("bye".equalsIgnoreCase(message)) {
                        System.out.println("Server disconnected.");
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection lost.");
            }
        });
        receiveThread.start();
        
        System.out.println("Type messages (type 'bye' to exit):");
        String clientMessage;
        while ((clientMessage = userInput.readLine()) != null) {
            out.println(clientMessage);
            if ("bye".equalsIgnoreCase(clientMessage)) {
                break;
            }
        }
        
        stopConnection();
    }

    public void stopConnection() throws IOException {
        if (in != null) in.close();
        if (out != null) out.close();
        if (clientSocket != null) clientSocket.close();
        if (userInput != null) userInput.close();
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        try {
            client.startConnection("localhost", 8080);
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}