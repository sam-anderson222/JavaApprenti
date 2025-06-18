package com.examples.DataObjects;

// This abstract class is inherited by each Item implementation class just so I don't have to make the same fields for each one.
public abstract class ItemDataTemplate {
    protected String itemName;
    protected double itemPrice;
    protected int itemQuantity;

    public ItemDataTemplate(String itemName, double itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
}
