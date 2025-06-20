package com.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.examples.DataObjects.Product;
import com.examples.DataObjects.Products.Apple;
import com.examples.DataObjects.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for the Cart Service
 */
public class CartServiceTest {
    public static CartService cart;

    @BeforeEach
    void setUp() {
        cart = new CartService();
    }

    // I keep getting weird error if I try to assertEquals the result object (I think it's checking to see if they are the same memory address)
    // So I instead just check both fields against one another.

    @Test
    @DisplayName("Getting item with valid product ID.")
    void getValidProductFromProductTable() {
        Result<Product> expected = new Result<>(new Apple("Opal Apple", "Sweet & Tart Yellow Apple", 1.99, true), true);
        Result<Product> actual =  cart.getProductWithID("1001"); // ID 1001 are Opal Apples.

        assertEquals(expected.getData().toString(), actual.getData().toString()); // Compare the strings created by the data from both objects.
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    @DisplayName("Getting item with invalid product ID.")
    void getInvalidProductFromProductTable() {
        Result<Product> expected = new Result<>(null, false);
        Result<Product> actual =  cart.getProductWithID("Invalid ID");


        assertEquals(expected.getStatus(), actual.getStatus()); // See if null equals null
        assertEquals(expected.getData(), actual.getData());
    }

    @Test
    @DisplayName("Remove some units from item in shopping cart.")
    void removeAllUnitsFromItemInCart() {
        // Adding item to cart
        // Product ID 1001 are opal apples (all product ID mappings are in the ProductTable class)
        cart.addItemToCart(cart.getProductWithID("1001").getData(), 10); // Only item in cart.

        Result<String> expected = new Result<>("5 Opal Apple removed from cart.", true);
        Result<String> actual = cart.removeItemFromCart(1, 5); // Remove first item from cart (the apples)

        // I keep getting weird error if I try to assertEquals the result object (I think it's checking to see if they are the mem address)
        // So I instead just check both fields against one another.
        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    @DisplayName("Remove all units from item in shopping cart causing the item to be removed from the cart.")
    void removeSomeUnitsFromItemInCart() {
        // Adding item to cart
        // Product ID 1001 are opal apples (all product ID mappings are in the ProductTable class)
        cart.addItemToCart(cart.getProductWithID("1001").getData(), 10); // Only item in cart.

        Result<String> expected = new Result<>("Opal Apple removed from cart.", true);
        Result<String> actual = cart.removeItemFromCart(1, 10); // Remove first item from cart (the apples)

        // I keep getting weird error if I try to assertEquals the result object (I think it's checking to see if they are the mem address)
        // So I instead just check both fields against one another.
        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertTrue(cart.getCart().isEmpty()); // Item should be removed from cart, causing the cart to become empty.
    }

    @Test
    @DisplayName("Input invalid index to remove item")
    void removeItemWithInvalidIndex() {
        Result<String> expected = new Result<>("Error. Item with this index number could not be found! Please try again.", false);
        Result<String> actual = cart.removeItemFromCart(1, 1); // No item exists at index 1 as cart is empty.

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    @DisplayName("Removing a non-positive number of units.")
    void removeItemWithInvalidQuantity() {
        cart.addItemToCart(cart.getProductWithID("1001").getData(), 10); // Only item in cart.

        Result<String> expected = new Result<>("Error. Cannot remove non-positive number of units! Please try again.", false);
        Result<String> actual = cart.removeItemFromCart(1, -100); // Removing -100 units from index 1.

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }


}