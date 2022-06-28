package com.lmig.math;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }
    @Test
    public void testAdd(){
        int a = 10;
        int b = 20;
        int expected = 30;
        int actual = calculator.add(a, b);
        assertEquals(expected, actual);
    }

    @Test
    public void testFactorial(){
        int n = 5;
        int expected = 120;
        int actual = calculator.factorial(n);
        assertEquals(expected, actual);
    }
}
