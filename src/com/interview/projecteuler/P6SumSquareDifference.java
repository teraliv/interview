package com.interview.projecteuler;

import java.util.stream.IntStream;

/**
 * Problem 6: Sum square difference
 *
 * Reference:
 * https://projecteuler.net/problem=6
 */
public class P6SumSquareDifference {

    /**
     * Finds the difference between the sum of the squares of the first one hundred natural
     * numbers and the square of the sum.
     */
    private static int difference(int num) {
        return squareOfSum(num) - sumOfSquares(num);
    }

    /**
     * Finds the sum of the squares of the first ten natural numbers
     */
    private static int sumOfSquares(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += Math.pow(i, 2);
        }
        return sum;
    }

    /**
     * Finds the square of the sum of the first ten natural numbers
     */
    private static int squareOfSum(int num) {

        int sum = IntStream.range(1, num + 1).sum();

        return (int) Math.pow(sum, 2);
    }

    public static void main(String[] args) {
        System.out.println(difference(100));
    }

}
