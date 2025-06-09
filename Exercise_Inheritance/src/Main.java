import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();

        // Adding some demo payments.
        payments.add(new CreditCard(102.50, 11223344, "Visa"));
        payments.add(new DirectDebit(42.00, 4231423, 3724537, "Alliant", 1.50));
        payments.add(new GiftCard(10.00, 25.00, "x001Steam", 0)); // Balance greater than amount
        payments.add(new GiftCard(50.00, 25.00, "x002Apple", 0)); // Balance smaller than transaction amount

        // Calling print string on each payment
        System.out.println("\n(Creating payments)");
        for (int i = 0; i < payments.size(); i++) {
            System.out.println(payments.get(i).toString());
        }

        // Processing payments
        System.out.println("\n(Processing payments)");
        for (int i = 0; i < payments.size(); i++) {
            payments.get(i).processPayment();
        }


        // Affect of processing payment (only on gift cards)
        System.out.println("\n(After processing payments)");
        for (int i = 0; i < payments.size(); i++) {
            System.out.println(payments.get(i).toString());
        }
    }
}
