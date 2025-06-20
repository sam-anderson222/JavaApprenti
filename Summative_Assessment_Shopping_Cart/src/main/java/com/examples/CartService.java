package com.examples;

import com.examples.DataObjects.CartEntry;
import com.examples.DataObjects.Product;
import com.examples.DataObjects.ProductTable;
import com.examples.DataObjects.Result;

import java.util.ArrayList;
import java.util.HashMap;

public class CartService {
    private ArrayList<CartEntry> cart;
    private final ProductTable productTable;

    public CartService() {
        cart = new ArrayList<>(); // Initialize the shopping cart.
        productTable = new ProductTable(); // Holds all the products being sold by the store.
    }

    public Result<String> addItemToCart(String productID, int quantity) {
        // Check for reasons why this function could fail (invalid productID or quantity)
        if (!getProductWithID(productID).getStatus()) { // If invalid productID
            return new Result<>("Error, item with this ID not found! Please try again.", false);
        } else if (quantity <= 0) { // If invalid quantity
            return new Result<>("Error. Cannot add non-positive number of units! Please try again.", false);
        }

        Product product = getProductWithID(productID).getData(); // Gets the product the user wishes to add to cart.
        Result<CartEntry> itemAlreadyInCart = hasProductInCart(product); // Returns if the user already has the product in their cart.

        if (itemAlreadyInCart.getStatus()) { // If user has product in their cart already
            itemAlreadyInCart.getData().addProductQuantity(quantity); // Add to quantity in cart.
            return new Result<>(String.format("%d more %s added to cart.", quantity, product.getProductName()), true);
        } else { // If item not already in cart
            cart.add(new CartEntry(product, quantity)); // Add new entry to cart.
            return new Result<>(String.format("%s added to cart.", product.getProductName()), true);
        }
    }

    // Index is one-based, so will have to be converted to zero base.
    public Result<String> removeItemFromCart(int index, int quantity) {
        // Check for reasons why removeItemFromCart could fail (either from invalid index or quantity)
        if (index < 1 || index > cart.size()) { // I check if the index is correct in the remove item workflow class, but I want to do it here as well so I can test it.
            return new Result<>("Error. Item with this index number could not be found! Please try again.", false);
        } else if (quantity <= 0) {
            return new Result<>("Error. Cannot remove non-positive number of units! Please try again.", false);
        }

        CartEntry cartItem = cart.get(index - 1); // Gets the item we are removing.
        cartItem.removeProductQuantity(quantity); // removes number of units from item

        // Should item be entirely removed from cart or not?
        if (cart.get(index - 1).getProductQuantity() <= 0) {
            // If there are less than 1 unit of this product left in cart, then remove from cart entirely
            CartEntry removedItem = cart.remove(index - 1); // remove item from list.
            return new Result<>(String.format("%s removed from cart.", removedItem.getProduct().getProductName()), true); // Item successfully removed.
        } else {
            // If some, but not all unit were removed, then say how many were removed
            return new Result<>(String.format("%d %s removed from cart.", quantity, cartItem.getProduct().getProductName()), true); // Item successfully removed.
        }
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

    // Returns the total price of the current cart
    public double calculateTotal() {
        double total = 0;
        for (CartEntry item: cart) {
            total += item.getCartEntryPrice();
        }

        return total;
    }

    // Removes all items from the cart
    public void clearCart() {
        cart = new ArrayList<>();
    }

    public ArrayList<CartEntry> getCart() {
        return cart;
    }


    public HashMap<String, Product> getProductTable() {
        return productTable.getProductHashMap();
    }

    // Checks if a product is already in the user's cart.
    private Result<CartEntry> hasProductInCart(Product p) {
        for (CartEntry cartEntry : cart) {
            if (cartEntry.getProduct() == p) { // Check if memory address are the same.
                return new Result<>(cartEntry, true);
            }
        }

        return new Result<>(null, false); // If item not found.
    }
}
