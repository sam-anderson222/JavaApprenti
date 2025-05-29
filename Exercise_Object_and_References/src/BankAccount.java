public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void displayBalance() {
        System.out.printf("Updated Balance (%s): $%.2f%n", owner, balance);
    }
}
