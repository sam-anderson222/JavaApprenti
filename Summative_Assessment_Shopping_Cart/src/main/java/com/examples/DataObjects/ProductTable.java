package com.examples.DataObjects;

import com.examples.DataObjects.Products.Apple;
import com.examples.DataObjects.Products.Bread;
import com.examples.DataObjects.Products.Deli;

import java.util.HashMap;

// Holds a HashMap of all product offered by the store. Uses product IDs to find products (ex: ID - "1332" -> Product - Apple)
// This data object is held in the CartService.
public class ProductTable {
    private HashMap<String, Product> productLookupTable;

    public ProductTable() {
        productLookupTable = new HashMap<>(); // Create HashMap

        // Adding products to product lookup table. the key is the productID.
        productLookupTable.put("1001", new Apple("Opal Apple", "Sweet & Tart Yellow Apple", 1.99, true));
        productLookupTable.put("1002", new Apple("Fuji Apple", "Red & Crisp Apple", 2.49, false));
        productLookupTable.put("2001", new Bread("French Loaf", "Freshly Cooked French Bread", 1.29, true));
        productLookupTable.put("2002", new Bread("Sandwich Bread", "White Bread for Sandwiches", 3.49, false));
        productLookupTable.put("3001", new Deli("Kosher Beef", "Thinly Sliced Beef for Sandwiches", 7.98, true));
        productLookupTable.put("3002", new Deli("Baby Back Ribs", "Uncooked Fresh Baby Back Ribs", 8.99, false));
    }

    // Getter function
    public HashMap<String, Product> getProductHashMap() {
        return productLookupTable;
    }


}
