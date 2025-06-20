package com.examples.DataObjects;

// A cart entry is made up of a product and the quantity of the product being purchased.
public class CartEntry {
    private final Product product;
    private int productQuantity;

    public CartEntry(Product product, int productQuantity) {
        this.product = product;
        this.productQuantity = productQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void removeProductQuantity(int productQuantity) {
        this.productQuantity -= productQuantity;
    }

    public void addProductQuantity(int productQuantity) {
        this.productQuantity += productQuantity;
    }

    // Returns the price of this cart entry (Product unit price * Quantity being purchased)
    public double getCartEntryPrice() {
        return product.getProductPrice() * productQuantity;
    }
}
