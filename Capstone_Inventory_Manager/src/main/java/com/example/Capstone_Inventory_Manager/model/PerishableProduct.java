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
    public String toProductTableRow() {
        return String.format("%6s | %14s | %8d | $%9.2f | %16s | %10s | %12s",
                productID, productName, quantity, price,
                "PERISHABLE", expirationDate, "");
    }

    @Override
    public String toCsvLine() {
        return String.format("%s,%s,%d,%.2f,%s,%s%n",
                productID, productName, quantity, price,
                "PERISHABLE", expirationDate);
    }

    @Override
    public String toString() {
        return String.format("ID: %s%nName: %s%nQuantity: %d%nPrice: $%.2f%nProduct Type:%s%nExpiration: %s%n", productID, productName, quantity, price, productType,expirationDate);
    }
}
