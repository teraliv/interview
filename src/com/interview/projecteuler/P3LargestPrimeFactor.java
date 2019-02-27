package com.interview.projecteuler;

/**
 * Problem 4: Largest prime factor
 *
 * Reference:
 * https://projecteuler.net/problem=3
 */
public class P3LargestPrimeFactor {


    /**
     * Finds all prime factors of a given number.
     * Example: The prime factors of 13195 = 5 * 7 * 13 * 29
     */
    private static void primeFactorization(long num) {
        int divisor = 2;

        do {
            if (num % divisor == 0) {
                num = num / divisor;
                System.out.println(divisor);
            }
            else {
                divisor++;
            }
        }
        while (num != 1);
    }

    /**
     * Time complexity O(nlog(logn))
     */
    private static void sieveOfEratosthenes(int num) {
        int[] primes = new int[num];

        for (int i = 0; i < num; i++) {
            primes[i] = 1;
        }
        primes[0] = 0;
        primes[1] = 0;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (primes[i] == 1) {
                for (int j = 2; i * j < num; j++) {
                    primes[i * j] = 0;
                }
            }
        }

        for(int i = 0; i < num; i++) {
            if (primes[i] == 1) System.out.println(i);
        }
    }


    public static void main(String[] args) {
        primeFactorization(600851475143L);
    }
}
