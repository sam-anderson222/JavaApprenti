public class GiftCard extends Payment{
    private double balance;
    private String accountNumber;
    private int loyaltyPoints;

    public GiftCard(double amount, double balance, String accountNumber, int loyaltyPoints) {
        super(amount);
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return String.format("Payment: %s | Transaction Amount: $%.2f | Type: %s | Balance: $%.2f | Points: %d",
                accountNumber, amount, "Gift Card", balance, loyaltyPoints);
    }

    @Override
    public boolean processPayment() {
        System.out.println("Processing gift card and adding loyalty points.");
        if (balance >= amount) {
            balance -= amount;
            loyaltyPoints += (int) amount * 100;
            System.out.printf("Payment successful, %d loyalty points added.%n", (int) amount * 100);
            return true;
        } else {
            System.out.println("Insufficient balance on gift card to process payment.");
            return false;
        }

    }


}
