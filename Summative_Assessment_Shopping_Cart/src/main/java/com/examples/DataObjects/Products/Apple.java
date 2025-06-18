package com.examples.DataObjects.Products;

import com.examples.DataObjects.*;

public class Apple extends ProductParentClass implements Product {
    private final boolean isOrganic;


    public Apple(String productName, String productDescription, double productPrice, boolean isOrganic) {
        super(productName,productDescription,productPrice);
        this.isOrganic = isOrganic;
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

    public boolean getIsOrganic() {
        return isOrganic;
    }
}
