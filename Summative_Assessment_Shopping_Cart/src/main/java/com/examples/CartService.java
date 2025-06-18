package com.examples;

import com.examples.DataObjects.CartEntry;
import com.examples.DataObjects.Product;
import com.examples.DataObjects.Result;

import java.util.ArrayList;

public class CartService {
    private ArrayList<CartEntry> cart;

    public CartService() {
        cart = new ArrayList<>(); // Initialize the shopping cart.
    }

    public Result<String> addProductToCart(Product product, int quantity) {
        cart.add(new CartEntry(product, quantity));
        return new Result<>(String.format("%s added to cart", product.getProductName()), true);
    }
}
