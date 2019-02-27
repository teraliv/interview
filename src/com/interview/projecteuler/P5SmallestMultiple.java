package com.interview.projecteuler;

/**
 * Problem 5: Smallest multiple
 *
 * Reference:
 * https://projecteuler.net/problem=5
 */
public class P5SmallestMultiple {

    /**
     * Finds smallest positive number that is evenly
     * divisible by all of the numbers from 1 to 20.
     */
    private static int findSmallestEvenDivisibilityNumber() {

        for (int num = 0; num < Integer.MAX_VALUE; num += 20) {
            if (num != 0 && isDivisible1to20(num)) return num;
        }

        return 0;
    }

    /**
     * Check if a number is evenly divisible by all of the numbers from 1 to 20.
     */
    private static boolean isDivisible1to20(int num) {
        for (int i = 1; i <= 20; i++) {
            if (num % i != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(findSmallestEvenDivisibilityNumber());
    }
}
