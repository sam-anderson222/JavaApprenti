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
    public String toProductTableRow() {
        return String.format("%6s | %14s | %8d | $%9.2f | %16s | %10s | %12s",
                productID, productName, quantity, price,
                "ELECTRONIC", "", brand);
    }

    @Override
    public String toCsvLine() {
        return String.format("%s,%s,%d,%.2f,%s,%s%n",
                productID, productName, quantity, price,
                "ELECTRONIC", brand);
    }

    @Override
    public String toString() {
        return String.format("ID: %s%nName: %s%nQuantity: %d%nPrice: $%.2f%nProduct Type:%s%nBrand: %s%n", productID, productName, quantity, price, productType,brand);
    }
}
