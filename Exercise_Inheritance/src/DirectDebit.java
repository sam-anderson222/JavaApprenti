public class DirectDebit extends Payment{
    private long routingNumber, accountNumber;
    private String bankName;
    private double processingFee;

    public DirectDebit(double amount, long routingNumber, long accountNumber, String bankName, double processingFee) {
        super(amount);
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.processingFee = processingFee;
    }

    @Override
    public String toString() {
        return String.format("Payment: %d | Transaction Amount: $%.2f | Type: %s | Bank: %s",
                accountNumber, amount, "Direct Debit", bankName);
    }

    @Override
    public boolean processPayment() {
        System.out.printf("Direct debit processing fee: $%.2f.%n", processingFee);
        System.out.printf("Sending transaction to bank: %s,%n", bankName);
        return true;
    }
}
