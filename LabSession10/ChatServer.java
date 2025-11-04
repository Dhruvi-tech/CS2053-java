import java.io.*;
import java.net.*;

public class ChatServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader userInput;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
        System.out.println("Waiting for client connection...");
        
        clientSocket = serverSocket.accept();
        System.out.println("Client connected!");
        
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        userInput = new BufferedReader(new InputStreamReader(System.in));
        
        Thread receiveThread = new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);
                    if ("bye".equalsIgnoreCase(message)) {
                        System.out.println("Client disconnected.");
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection lost.");
            }
        });
        receiveThread.start();
        
        System.out.println("Type messages (type 'bye' to exit):");
        String serverMessage;
        while ((serverMessage = userInput.readLine()) != null) {
            out.println(serverMessage);
            if ("bye".equalsIgnoreCase(serverMessage)) {
                break;
            }
        }
        
        stop();
    }

    public void stop() throws IOException {
        if (in != null) in.close();
        if (out != null) out.close();
        if (clientSocket != null) clientSocket.close();
        if (serverSocket != null) serverSocket.close();
        if (userInput != null) userInput.close();
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        try {
            server.start(8080);
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}