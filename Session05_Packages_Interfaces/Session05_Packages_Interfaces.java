interface Loan {
    void calculateInterest(double amount, int years);
}

class HomeLoan implements Loan {
    protected double rate = 7.5; // Protected access

    @Override
    public void calculateInterest(double amount, int years) {
        double interest = (amount * rate * years) / 100;
        System.out.println("Home Loan Interest: Rs. " + interest);
    }
}

class CarLoan implements Loan {
    private double rate = 9.0; // Private access

    @Override
    public void calculateInterest(double amount, int years) {
        double interest = (amount * rate * years) / 100;
        System.out.println("Car Loan Interest: Rs. " + interest);
    }
}

public class Session05_Packages_Interfaces {
    public static void main(String[] args) {
        Loan loan1 = new HomeLoan();
        Loan loan2 = new CarLoan();

        System.out.println("Loan Interest Calculations:");
        loan1.calculateInterest(500000, 10);
        loan2.calculateInterest(300000, 5);
    }
}