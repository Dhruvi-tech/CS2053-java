abstract class Account {
    String accountHolder;
    double balance;

    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    abstract void displayAccountInfo();
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountInfo() {
        System.out.println("Savings Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountHolder, double balance, double overdraftLimit) {
        super(accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void displayAccountInfo() {
        System.out.println("Current Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

public class LabSession4 {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("Alice", 5000, 5);
        Account acc2 = new CurrentAccount("Bob", 10000, 2000);

        acc1.displayAccountInfo();
        System.out.println();
        acc2.displayAccountInfo();
    }
}
