public class CreditCard extends Payment{
    private long accountNumber;
    private String cardVendor;

    public CreditCard(double amount, long accountNumber, String cardVendor) {
        super(amount);
        this.accountNumber = accountNumber;
        this.cardVendor = cardVendor;
    }

    @Override
    public String toString() {
        return String.format("Payment: %d | Transaction Amount: $%.2f | Type: %s | Card Vendor: %s",
                accountNumber, amount, "Direct Debit", cardVendor);
    }

    @Override
    public boolean processPayment() {
        System.out.printf("Processing via: %s for $%.2f.%n", cardVendor, amount);
        return true;
    }
}
