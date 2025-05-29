
public class ShoppingCartApp {
    enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED
    }

    enum ShippingStatus {
        STANDARD,
        TWO_DAY,
        OVERNIGHT
    }
    public static void main(String[] args) {
        // String Variables (Added for Shopping Cart Strings Exercise)
        String businessName = "Zebra Goods";
        String contactInfo = "123-454-3212";
        String itemDescription = "Pint of chocolate ice cream.";

        // Product Information
        int productID = 1;
        int productCategory = 2;
        float productCost = 2.56f; // Cost to purchase
        float productPrice = 4.99f; // Price we sell at
        int productQuantity = 78; // Number we have in stock

        // Calculations
        float totalCost = productCost * productQuantity; // How much it costed us to purchase the inventory
        float profitMargin = productPrice - productCost; // profit margin on each unit, stored as a decimal not a percentage.
        float totalPotentialProfit = (profitMargin * productQuantity);

        // Business and product info. (Added for Strings Exercise)
        System.out.println("\n(Welcome to the shopping cart app!)\n");
        System.out.println("Business Name: " + businessName);
        System.out.println("Have questions? Contact us at: " + contactInfo);
        System.out.println("\nProduct 1 Info: " + itemDescription);
        // Output

        System.out.printf("Total cost of inventory: $%.2f%n", totalCost);
        System.out.printf("Profit margin on each unit: $%.2f%n", profitMargin);
        System.out.printf("Total potential profit: $%.2f%n", totalPotentialProfit);

        // -+- Shopping Cart Enum Exercise Code -+-

        // Declaring values
        OrderStatus orderStatus = OrderStatus.PROCESSING;
        ShippingStatus shipStatus = ShippingStatus.TWO_DAY;

        // Printing enum values
        System.out.println("\n(Printing Shipping and Order Statuses)");
        System.out.println(ShippingStatus.STANDARD);
        System.out.println(ShippingStatus.TWO_DAY);
        System.out.println(ShippingStatus.OVERNIGHT);
        System.out.println("Order Status: " + orderStatus);
        System.out.println(OrderStatus.PENDING);
        System.out.println(OrderStatus.PROCESSING);
        System.out.println(OrderStatus.SHIPPED);
        System.out.println(OrderStatus.DELIVERED);
        System.out.println("Ship Status: " + shipStatus);

        // Goodbye text
        System.out.println("\n(Thank you for using this app. Goodbye!)\n");



    }
}
