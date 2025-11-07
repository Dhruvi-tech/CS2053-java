class Printer {
    public synchronized void printDocument(String user, int pages) {
        System.out.println(user + " started printing a document (" + pages + " pages).");
        for (int i = 1; i <= pages; i++) {
            System.out.println("Printing page " + i + " for " + user);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted for " + user);
            }
        }
        System.out.println(user + " finished printing.\n");
    }
}

class User implements Runnable {
    private String name;
    private Printer printer;
    private int pages;

    public User(String name, Printer printer, int pages) {
        this.name = name;
        this.printer = printer;
        this.pages = pages;
    }

    @Override
    public void run() {
        printer.printDocument(name, pages);
    }
}

public class LabSession7 {
    public static void main(String[] args) {
        System.out.println("=== Office Print Queue Simulation ===\n");

        Printer sharedPrinter = new Printer();

        Thread user1 = new Thread(new User("Alice", sharedPrinter, 3));
        Thread user2 = new Thread(new User("Bob", sharedPrinter, 2));
        Thread user3 = new Thread(new User("Charlie", sharedPrinter, 4));

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All print jobs completed successfully!");
    }
}