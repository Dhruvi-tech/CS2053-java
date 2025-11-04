import java.util.Scanner;

public class LabSession10 {
    public static void main(String[] args) {
        System.out.println("=== TCP Client-Server Chat Application ===");
        System.out.println("Choose an option:");
        System.out.println("1. Start Server");
        System.out.println("2. Start Client");
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        
        try {
            if (choice == 1) {
                System.out.println("Starting server...");
                ChatServer server = new ChatServer();
                server.start(8080);
            } else if (choice == 2) {
                System.out.println("Starting client...");
                ChatClient client = new ChatClient();
                client.startConnection("localhost", 8080);
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        scanner.close();
    }
}