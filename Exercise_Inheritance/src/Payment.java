public class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return String.format("Transaction Amount: $%.2f| Type: %s", amount, "General Payment");
    }

    public boolean processPayment() {
        return true;
    }
}
