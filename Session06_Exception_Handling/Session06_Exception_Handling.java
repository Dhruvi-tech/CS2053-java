class LowBalanceException extends Exception {
    LowBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    String accountHolder;
    double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void withdraw(double amount) throws LowBalanceException {
        if (amount > balance) {
            throw new LowBalanceException("Withdrawal failed: Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }
}

public class Session06_Exception_Handling {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Alice", 5000);

        try {
            acc.withdraw(3000);
            acc.withdraw(2500);
        } catch (LowBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
