package com.examples.DataObjects;

import javax.lang.model.type.NullType;

public interface Item {
    String getItemName();
    double getItemPrice();
    int getItemQuantity();

    // To - do: Add addItemQuantity method
    Result<String> removeItemQuantity(int quantity);


}
