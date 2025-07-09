package com.example.Capstone_Inventory_Manager.model;

import java.math.BigDecimal;

public class Product {
    protected String productID;
    protected String productName;
    protected int quantity;
    protected BigDecimal price;

    public Product (String productID, String productName, int quantity, BigDecimal price) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
