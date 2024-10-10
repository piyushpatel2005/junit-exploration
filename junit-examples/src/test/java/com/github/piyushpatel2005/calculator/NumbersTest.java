package com.github.piyushpatel2005.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class NumbersTest {
    Numbers numbers = new Numbers();

    @ParameterizedTest
    @MethodSource("provideNumbersForIsEven")
    @DisplayName("Parameterized test for is Even")
    void testIsEven(int number, boolean expected) {
        assertEquals(expected, numbers.isEven(number));
    }

    static Stream<Arguments> provideNumbersForIsEven() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(10, true),
                Arguments.of(0, true),
                Arguments.of(5, false)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, -11, 507})
    @DisplayName("Test is Odd with True results")
    void testIsOdd_returnsTrueForOddNumbers(int number) {
        assertTrue(numbers.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100, -20, 2222})
    @DisplayName("Test is Odd with True results")
    void testIsOdd_returnsFalseForEvenNumbers(int number) {
        assertFalse(numbers.isOdd(number));
    }

    @ParameterizedTest
    @CsvSource({
            "20, true",
            "4, false",
            "-1, false",
            "105, true",
            "0, true"
    })
    @DisplayName("Test Is Divisible By Five")
    void testIsDivisibleByFive(int number, boolean expected) {
        assertEquals(expected, numbers.isDivisibleByFive(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/divisible_by_five.csv", delimiter = '|')
    @DisplayName("Test Divisible by Five using CsvFileSource")
    void testIsDivisibleByFiveUsingFile(int number, boolean expected) {
        assertEquals(expected, numbers.isDivisibleByFive(number));
    }

}