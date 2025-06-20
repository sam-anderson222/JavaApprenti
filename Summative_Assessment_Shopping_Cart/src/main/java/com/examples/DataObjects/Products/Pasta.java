package com.examples.DataObjects.Products;

import com.examples.DataObjects.Product;
import com.examples.DataObjects.ProductParentClass;

public class Pasta extends ProductParentClass implements Product {
    private final boolean isGlutenFree;


    public Pasta(String productName, String productDescription, double productPrice, boolean isGlutenFree) {
        super(productName,productDescription,productPrice);
        this.isGlutenFree = isGlutenFree;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getProductDescription() {
        return productDescription;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return String.format("%-16s | $%-6.2f | Gluten:%6b | %-40s", productName, productPrice, isGlutenFree, productDescription);
    }

    public boolean getIsGlutenFree() {
        return isGlutenFree;
    }
}
