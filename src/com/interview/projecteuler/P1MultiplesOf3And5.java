package com.interview.projecteuler;

import java.util.stream.IntStream;

/**
 * Problem 1: Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of
 * 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * Answer: 233168
 *
 * Reference:
 * https://projecteuler.net/problem=1
 */
public class P1MultiplesOf3And5 {

    private static int multiples(int num) {
        int sum;

        // old school
        // for (int i = 0; i < num; i++) {
        //     if ( (i % 3 == 0) || (i % 5 == 0)) {
        //         sum += i;
        //     }
        // }

        // streams
        IntStream multiples = IntStream.range(1, num);
        sum = multiples.filter(n -> (n % 3 == 0 || n % 5 == 0)).sum();

        return sum;
    }

    public static void main(String[] args) {
        int sum = multiples(1000);
        System.out.println(sum);
    }
}
