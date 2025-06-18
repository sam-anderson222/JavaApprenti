package com.examples.DataObjects;

// Product all inherit fields from this class , so I don't have to write the same fields for every product.
public abstract class ProductParentClass {
    protected String productName;
    protected String productDescription;
    protected double productPrice; // <- Price per unit. Total price is calculated in the CartEntry where the quantity is multiplied by this value.

    public ProductParentClass(String productName, String productDescription, double productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }
}
