package com.interview.dynamic;

/**
 * 509. Fibonacci Number
 *
 *
 * Reference:
 * https://leetcode.com/problems/fibonacci-number/
 *
 * Time/Space complexity: O(n) - DP
 */
public class FibonacciNumber {

    /**
     * Example using DP approach
     *
     *  f(0) f(1) f(2) f(3) f(4) f(5) f(6) f(7)
     * +----+----+----+----+----+----+----+----+
     * |  0 |  1 |  1 |  2 |  3 |  5 |  8 | 13 |
     * +----+----+----+----+----+----+----+----+
     */
    private static int fibDP(int n) {
        if (n == 0) return 0;

        int[] seq = new int[n+1];
        seq[1] = 1;

        for (int i = 2; i <= n; i++)
            seq[i] = seq[i-2] + seq[i-1];

        return seq[n];
    }


    /**
     * Example using recursive approach.
     */
    private static int fibRec(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibRec(n-1) + fibRec(n-2);
    }


    /**
     * Test cases
     */
    public static void main(String[] args) {
        System.out.println( fibRec(6) );    // 8
        System.out.println( fibDP(7) );     // 13
    }
}
