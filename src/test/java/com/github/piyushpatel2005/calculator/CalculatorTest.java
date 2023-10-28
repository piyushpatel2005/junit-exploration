package com.github.piyushpatel2005.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Test")
class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test Positive Numbers Addition")
    void testAdd() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @DisplayName("Test Negative Numbers Addition")
    void testAddNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    @DisplayName("Test Subtraction")
    void testSubtraction() {
        assertEquals(1, calculator.subtract(2, 1));
        assertEquals(-5, calculator.subtract(5, 10));
        assertEquals(-5, calculator.subtract(-2, 3));
    }

    @Test
    @DisplayName("Test Multiplication")
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
        assertEquals(0, calculator.multiply(0, 10));
    }

    @Test
    @DisplayName("Test Division")
    void testDivision() {
        assertEquals(1, calculator.divide(3, 2));
        assertEquals(2, calculator.divide(4, 2));
        assertEquals(2, calculator.divide(12, 5));
    }
}