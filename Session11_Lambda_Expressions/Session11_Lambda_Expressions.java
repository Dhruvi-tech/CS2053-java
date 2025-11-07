import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return id + " - " + name + " - " + price;
    }
}

public class Session11_Lambda_Expressions {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 75000));
        products.add(new Product(2, "Phone", 35000));
        products.add(new Product(3, "Tablet", 25000));
        products.add(new Product(4, "Monitor", 15000));
        products.add(new Product(5, "Headphones", 5000));

        System.out.println("Original List:");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("\nSorted by Price:");
        products.forEach(System.out::println);

        products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println("\nSorted by Name:");
        products.forEach(System.out::println);
    }
}

