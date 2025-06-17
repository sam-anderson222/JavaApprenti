package com.examples;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Test adding two numbers")
    void testAdd() {
        int actual = calc.add(2, 2);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test subtracting two numbers")
    void testSubtract() {
        int actual = calc.subtract(10, 5);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test dividing by 0")
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(19, 0));
    }
}
