package com.examples;

import com.examples.DataObjects.*;

import javax.lang.model.type.NullType;
import java.lang.reflect.Array;
import java.util.ArrayList;

// Holds the user's cart.
public class CartService {
    private ArrayList<Item> cart;

    public CartService() {
        cart = new ArrayList<>();
    }

    public Result<String> addItemToCart(Item item) {
        cart.add(item);
        return new Result<>("Success.", true);
    }

    public ArrayList<Item> getCart() {
        return cart;
    }
}
