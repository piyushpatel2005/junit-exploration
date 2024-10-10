package com.github.piyushpatel2005.calculator;

public class Numbers {
    public boolean isDivisibleByFive(int number) {
        return number % 5 == 0;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isOdd(int number) {
        return !isEven(number);
    }
}
