package com.examples;

import com.examples.DataObjects.CartEntry;
import com.examples.DataObjects.Product;
import com.examples.DataObjects.ProductTable;
import com.examples.DataObjects.Products.Apple;
import com.examples.DataObjects.Result;

import java.util.ArrayList;
import java.util.HashMap;

public class CartService {
    private ArrayList<CartEntry> cart;
    private ProductTable productTable;

    public CartService() {
        cart = new ArrayList<>(); // Initialize the shopping cart.
        productTable = new ProductTable(); // Holds all the products being sold by the store.
    }

    public Result<String> addItemToCart(Product product, int quantity) {
        cart.add(new CartEntry(product, quantity));
        return new Result<>(String.format("%s added to cart", product.getProductName()), true);
    }

    // Index is one-based, so will have to be converted to zero base.
    public Result<String> removeItemFromCart(int index, int quantity) {
        // Check for reasons why removeItemFromCart could fail (either from invalid index or quantity)
        if (index < 1 || index > cart.size()) {
            return new Result<>("Error. Item with this index number could not be found! Please try again.", false);
        } else if (quantity <= 0) {
            return new Result<>("Error. Cannot remove non-positive number of units! Please try again.", false);
        }

        CartEntry cartItem = cart.get(index - 1);

        cartItem.removeProductQuantity(quantity); // removes number of units from item

        // Should item be entirely removed from cart or not?
        if (cart.get(index - 1).getProductQuantity() <= 0) { // If user removes more or equal to the number of this item in their cart.
            // If there are less than 1 unit of this product left in cart, then remove from cart entirely
            CartEntry removedItem = cart.remove(index - 1); // remove item from list.
            return new Result<>(String.format("%s removed from cart.", removedItem.getProduct().getProductName()), true); // Item successfully removed.
        } else { // If some, but not all unit were removed, then say how many were removed
            return new Result<>(String.format("%d %s removed from cart.", quantity, cartItem.getProduct().getProductName()), true); // Item successfully removed.
        }
    }

    public ArrayList<CartEntry> getCart() {
        return cart;
    }

    // Returns a product object from the product table. Returns a result saying if the item was found or not.
    // If item was found, then the product is in the data field of the result.
    public Result<Product> getProductWithID(String productID) {
        HashMap<String, Product> productLookupTable = productTable.getProductHashMap();

        if (productLookupTable.containsKey(productID)) {
            return new Result<>(productLookupTable.get(productID), true);
        } else {
            return new Result<>(null, false); // If productID not found, return false.
        }
    }

    public HashMap<String, Product> getProductTable() {
        return productTable.getProductHashMap();
    }
}
