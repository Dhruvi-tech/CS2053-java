import java.util.Scanner;
class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

public class Session02_String_Handling_Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name, department, salary);

        if (args.length == 3) {
            emp = new Employee(args[0], args[1], Double.parseDouble(args[2]));
            System.out.println("\n--- Updated via Command-line Arguments ---");
        } else {
            System.out.println("\n--- Entered via Scanner ---");
        }

        emp.display();
        sc.close();
    }
}