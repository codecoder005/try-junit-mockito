package com.lmig.math;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    // factorial of a number using recursion
    public int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
