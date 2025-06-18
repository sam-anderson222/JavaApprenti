package com.examples;

import com.examples.DataObjects.*;

import com.examples.DataObjects.Items.Apple;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    @DisplayName("Testing removing from Apple item")
    void removeQuantityFromApple() {
        Item apple = new Apple("Apple", 2.99, 10);
        String expected = "5 apples removed.";
        String actual = apple.removeItemQuantity(5).getResult();
        assertEquals(expected, actual);
    }

}
