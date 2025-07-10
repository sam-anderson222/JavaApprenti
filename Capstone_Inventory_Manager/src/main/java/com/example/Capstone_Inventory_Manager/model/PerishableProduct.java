package com.example.Capstone_Inventory_Manager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PerishableProduct extends Product {
    private final LocalDate expirationDate;

    public PerishableProduct(String productID, String productName, int quantity, BigDecimal price, LocalDate expirationDate) {
        super(productID, productName, quantity, price);
        this.productType = ProductTypes.PERISHABLE;
        this.expirationDate = expirationDate;
    }

    @Override
    public String getExtraInfo() {
        return expirationDate.toString();
    }
}
