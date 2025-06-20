package com.examples;

import com.examples.DataObjects.Product;
import com.examples.DataObjects.Products.Apple;
import com.examples.DataObjects.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

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

    // Also note: Product ID 1001 are opal apples (I use this product a lot in my tests).
    // To see all product ID mappings, they are in the ProductTable class.

    @Test
    @DisplayName("Creating a CartService creates an empty ArrayList cart")
    void createsEmptyCart() {
        assertTrue(cart.getCart().isEmpty());
    }

    @Test
    @DisplayName("Getting item with valid product ID.")
    void getValidProductFromProductTable() {
        Result<Product> expected = new Result<>(new Apple("Opal Apple", "Sweet & Tart Yellow Apple", 1.99, true), true);
        Result<Product> actual =  cart.getProductWithID("1001"); // ID 1001 are Opal Apples.

        // Expected.getData() is an Product object, I use toString to compare their data instead of their memory addresses.
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
    @DisplayName("Add new item to empty cart")
    void addNewItemToCart() {
        Result<String> expected = new Result<>("Opal Apple added to cart.", true);
        Result<String> actual = cart.addItemToCart("1001", 10); // Add 10 opal apples to cart.

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(1, cart.getCart().size()); // Check if only one item is now in the cart.
    }

    @Test
    @DisplayName("Add item that is already in cart, causing it's quantity to increase instead of creating a new item in cart.")
    void addMoreOfSameItemToCart() {
        cart.addItemToCart("1001", 10); // Add 10 opal apple initially.

        Result<String> expected = new Result<>("5 more Opal Apple added to cart.", true);
        Result<String> actual = cart.addItemToCart("1001", 5); // Add 5 more opal apples to cart.

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(1, cart.getCart().size()); // Ensure the quantity of item has increased and that a new object wasn't created.
    }

    @Test
    @DisplayName("Attempt to add item with invalid product ID")
    void addWithInvalidProductID() {
        Result<String> expected = new Result<>("Error, item with this ID not found! Please try again.", false);
        Result<String> actual = cart.addItemToCart("Invalid ID", 1);

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    @DisplayName("Attempt to add item with invalid quantity")
    void addWithInvalidProductQuantity() {
        Result<String> expected = new Result<>("Error. Cannot add non-positive number of units! Please try again.", false);
        Result<String> actual = cart.addItemToCart("1001", -100); // ID is valid, but quantity isn't.

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }




    @Test
    @DisplayName("Remove some units from item in shopping cart.")
    void removeAllUnitsFromItemInCart() {
        // Adding item to cart
        cart.addItemToCart("1001", 10); // Only item in cart.

        Result<String> expected = new Result<>("5 Opal Apple removed from cart.", true);
        Result<String> actual = cart.removeItemFromCart(1, 5); // Remove first item from cart (the apples)

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(1, cart.getCart().size()); // Item was not removed from cart as not all units were removed.
    }

    @Test
    @DisplayName("Remove all units from item in shopping cart causing the item to be removed from the cart.")
    void removeSomeUnitsFromItemInCart() {
        cart.addItemToCart("1001", 10); // Only item in cart.

        Result<String> expected = new Result<>("Opal Apple removed from cart.", true);
        Result<String> actual = cart.removeItemFromCart(1, 10); // Remove first item from cart (the apples)

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertTrue(cart.getCart().isEmpty()); // Item object should be removed from cart, causing the cart to become empty.
    }

    @Test
    @DisplayName("Attempt to remove item from empty cart")
    void removeItemFromEmptyCart() {
        Result<String> expected = new Result<>("Error. Item with this index number could not be found! Please try again.", false);
        Result<String> actual = cart.removeItemFromCart(1, 1); // No item exists at index 1 as cart is empty.

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    @DisplayName("Attempt to remove item with invalid index")
    void removeItemWithInvalidIndex() {
        cart.addItemToCart("1001", 10); // Item at index 1

        Result<String> expected = new Result<>("Error. Item with this index number could not be found! Please try again.", false);
        Result<String> actual = cart.removeItemFromCart(2, 1); // No item exists at index 2.

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    @DisplayName("Removing a non-positive number of units.")
    void removeItemWithInvalidQuantity() {
        cart.addItemToCart("1001", 10); // Only item in cart.

        Result<String> expected = new Result<>("Error. Cannot remove non-positive number of units! Please try again.", false);
        Result<String> actual = cart.removeItemFromCart(1, -100); // Attempt to remove -100 units from index 1.

        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test
    @DisplayName("Test clearing the shopping cart")
    void canClearShoppingCart() {
        cart.addItemToCart("1001", 10); // Item in cart
        cart.clearCart(); // Clearing the cart.

        assertTrue(cart.getCart().isEmpty()); // Cart is now empty.
    }

    @Test
    @DisplayName("Test calculating the total price of all products in cart")
    void canCalculateCartTotal() {
        cart.addItemToCart("1001", 10); // Item in cart
        cart.addItemToCart("1002", 10); // Item in cart

        double expected = 44.80;
        double actual = cart.calculateTotal();

        assertEquals(expected, actual); // check if prices are equal.
    }

    @Test
    @DisplayName("Returns a cost of zero on a empty cart.")
    void returnsCostOfZeroOnEmptyCart() {
        double expected = 0;
        double actual = cart.calculateTotal();

        assertEquals(expected, actual); // check if prices are equal.
    }

    @Test
    @DisplayName("Can get cart")
    void canGetCart() {
        assertNotNull(cart.getCart());
    }

    @Test
    @DisplayName("Can get product table")
    void canGetProductHashMap() {
        assertNotNull(cart.getProductTable());
    }
}