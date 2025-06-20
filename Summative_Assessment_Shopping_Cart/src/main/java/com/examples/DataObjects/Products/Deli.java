package com.examples.DataObjects.Products;

import com.examples.DataObjects.Product;
import com.examples.DataObjects.ProductParentClass;

public class Deli extends ProductParentClass implements Product {
    private final boolean isKosher;


    public Deli(String productName, String productDescription, double productPrice, boolean isKosher) {
        super(productName,productDescription,productPrice);
        this.isKosher = isKosher;
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
        return String.format("%-14s | $%-6.2f | Kosher:%6b | %-40s", productName, productPrice, isKosher, productDescription);
    }

    public boolean getIsOrganic() {
        return isKosher;
    }
}
