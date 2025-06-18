package com.examples.DataObjects;

import com.examples.DataObjects.Products.Apple;
import com.examples.DataObjects.Products.Bread;

import java.util.HashMap;

// Holds a HashMap of all product offered by the store. Uses product IDs to find products (ex: ID - "1332" -> Product - Apple)
// This data object is held in the CartService.
public class ProductTable {
    private HashMap<String, Product> productLookupTable;

    public ProductTable() {
        productLookupTable = new HashMap<>(); // Create HashMap

        // Adding products to product lookup table.
        productLookupTable.put("1001", new Apple("Opal Apple", "Yellow Sweet & Tart Apple", 1.99, true));
        productLookupTable.put("1002", new Apple("Cosmic Crisp Apple", "Red & Crisp Apple", 2.49, false));
        productLookupTable.put("2001", new Bread("French Loaf", "Freshly cooked French bread", 1.29, true));
        productLookupTable.put("2002", new Bread("Sandwich Bread", "White bread for sandwiches", 1.29, false));
    }


}
