package com.examples.DataObjects.Items;

import com.examples.DataObjects.Item;
import com.examples.DataObjects.ItemDataTemplate;
import com.examples.DataObjects.Result;

public class Chips extends ItemDataTemplate implements Item {
    public Chips(String itemName, double itemPrice, int itemQuantity){
        super(itemName, itemPrice, itemQuantity);
    }

    @Override
    public String getItemName() {
        return this.itemName;
    }

    @Override
    public double getItemPrice() {
        return this.itemPrice;
    }

    @Override
    public int getItemQuantity() {
        return this.itemQuantity;
    }

    @Override
    public Result<String> removeItemQuantity(int quantity) {
        itemQuantity -= quantity;
        return new Result<>(String.format("%d bags of chips removed.", quantity), true);
    }
}
