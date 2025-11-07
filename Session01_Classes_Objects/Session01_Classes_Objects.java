class Book {
    String title;
    String author;
    double price;

    Book() {
        this("Unknown", "Unknown", 0.0);
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
        System.out.println("----------------------");
    }
}

public class Session01_Classes_Objects {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java Programming", "James Gosling", 499.99);
        Book b3 = new Book("Data Structures", "Robert Lafore", 350.75);

        b1.display();
        b2.display();
        b3.display();
    }
}
