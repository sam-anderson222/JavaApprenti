
public class ShoppingCartApp {
    public static void main(String[] args) {
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

        // Output
        System.out.println("Total cost of inventory: $" + totalCost);
        System.out.println("Profit margin on each unit: $" + profitMargin);
        System.out.println("Total potential profit: $" + totalPotentialProfit);


    }
}