import java.util.ArrayList;
import java.util.Iterator;

public class Session09_Collections_Framework {
    public static void main(String[] args) {
       
        ArrayList<Integer> marksList = new ArrayList<>();


        marksList.add(85);
        marksList.add(90);
        marksList.add(76);
        marksList.add(88);
        marksList.add(95);

        System.out.println("Initial Marks List: " + marksList);

     
        System.out.println("\nTraversing Marks List using Iterator:");
        Iterator<Integer> iterator = marksList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        
       
        marksList.set(2, 80); // changing 76 → 80
        System.out.println("\nAfter Updating index 2: " + marksList);



        marksList.remove(1); // removes 90
        System.out.println("\nAfter Deleting index 1: " + marksList);

 
        System.out.println("\nFinal Traversal using Iterator:");
        iterator = marksList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

