package com.example.Capstone_Inventory_Manager.model;

import java.math.BigDecimal;

public class ElectronicProduct extends Product {
    private final String brand;

    public ElectronicProduct(String productID, String productName, int quantity, BigDecimal price, String brand) {
        super(productID, productName, quantity, price);
        this.productType = ProductTypes.ELECTRONIC;
        this.brand = brand;
    }

    @Override
    public String getExtraInfo() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("ID: %s%nName: %s%nQuantity: %d%nPrice: $%.2f%nProduct Type:%s%nBrand: %s%n", productID, productName, quantity, price, productType,brand);
    }
}
