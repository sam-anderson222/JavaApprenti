package com.examples;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
    private StringCalculator calc;

    @BeforeEach
    void setUp() {
        calc = new StringCalculator();
    }

    @Test
    @DisplayName("Empty string returns zero")
    void emptyStringReturnsZero() {
        int actual = calc.add("");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("One number returns the number")
    void singleNumberReturnsNumber() {
        int actual = calc.add("1");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    @DisplayName("Add two numbers")
    void addTwoNumbers(String input) {
        int actual = calc.add(input);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add three numbers")
    void addThreeNumbers() {
        int actual = calc.add("1,2,3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Add with newline character instead of comma")
    void addWithNewlineCharacter() {
        int actual = calc.add("1,2\n3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding with custom delimiter")
    void addWithCustomDelimiter() {
        int actual = calc.add("//;\n1;2;3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Adding with another custom delimiter")
    void addWithCustomDelimiterTwo() {
        int actual = calc.add("//q\n2q6q5");
        int expected = 13;
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Add with single negative")
    void addWithSingleNegativeNumber() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> calc.add("1,-2,3"));
        assertEquals("Negatives not allowed: -2", ex.getMessage()); // Checks if the correct error message was thrown.
    }

    @Test
    @DisplayName("Add with multiple negatives")
    void addWithMultipleNegativeNumbers() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> calc.add("-1,-2,-3"));
        assertEquals("Negatives not allowed: -1 -2 -3", ex.getMessage()); // Checks if the correct error message was thrown.
    }

    @Test
    @DisplayName("Ignore number bigger than 1,000")
    void addIgnoringNumbersBiggerThan1K() {
        int actual = calc.add("2,1001");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Multi-character delimiters")
    void addWithMultiCharacterDelimiters() {
        int actual = calc.add("//[\\*\\*\\*]\n1***1"); // Have to use escape characters.
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Multiple delimiters")
    void addWithMultipleDelimiters() {
        int actual = calc.add("//[;][%][ppp][hello]\n2;3%4ppp2hello9");
        int expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Multiple delimiters and numbers over 1K")
    void addWithMultipleDelimitersAndWithNumberOver1K() {
        int actual = calc.add("//[f][g][qq]\n2f9999g10qq2");
        int expected = 14;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Multiple delimiters with negative number")
    void addWithMultipleDelimitersAndNegatives() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> calc.add("//[;][ss]\n3;-1ss-3"));
        assertEquals("Negatives not allowed: -1 -3", ex.getMessage()); // Checks if the correct error message was thrown.
    }

}
