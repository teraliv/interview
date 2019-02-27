package com.interview.projecteuler;

/**
 * Problem 2: Even Fibonacci numbers
 *
 * Reference:
 * https://projecteuler.net/problem=2
 */
public class P2EvenFibonacciNumbers {

    /**
     * Fibonacci sequence
     */
    private static int fib(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }


    public static void main(String[] args) {

        int sum = 0;
        for (int num = 1; num <= 33; num++) {
            int fibonacciNum = fib(num);
            if (fibonacciNum % 2 == 0) sum += fibonacciNum;
        }

        System.out.println(sum);
    }
}
