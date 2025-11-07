import java.util.ArrayList;

// Generic Box class
class Box<T> {
    private ArrayList<T> items = new ArrayList<>();

    // Add element to the box
    public void add(T item) {
        items.add(item);
    }

    // Print all elements in the box
    public void printItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

// Public class with main method
public class Session08_Wrapper_Classes_Generics {
    public static void main(String[] args) {
        // Box for Integers (autoboxing: int -> Integer)
        Box<Integer> intBox = new Box<>();
        intBox.add(10);   // autoboxed to Integer
        intBox.add(20);
        intBox.add(30);

        System.out.println("Integer Box contents:");
        intBox.printItems();

        // Box for Doubles (autoboxing: double -> Double)
        Box<Double> doubleBox = new Box<>();
        doubleBox.add(3.14);
        doubleBox.add(2.71);

        System.out.println("\nDouble Box contents:");
        doubleBox.printItems();

        // Box for Strings (no autoboxing, but works with generics)
        Box<String> stringBox = new Box<>();
        stringBox.add("Hello");
        stringBox.add("World");

        System.out.println("\nString Box contents:");
        stringBox.printItems();
    }
}

