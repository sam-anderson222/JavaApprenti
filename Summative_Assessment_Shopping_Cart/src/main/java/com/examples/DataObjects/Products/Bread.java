package com.examples.DataObjects.Products;

import com.examples.DataObjects.Product;
import com.examples.DataObjects.ProductParentClass;

public class Bread extends ProductParentClass implements Product {
    private boolean isFresh;

    public Bread(String productName, String productDescription, double productPrice, boolean isFresh) {
        super(productName,productDescription,productPrice);
        this.isFresh = isFresh;
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

    public boolean getIsFresh() {
        return isFresh;
    }
}
