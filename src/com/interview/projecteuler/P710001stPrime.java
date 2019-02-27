package com.interview.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 7: 10001st prime
 *
 * Reference:
 * https://projecteuler.net/problem=7
 */
public class P710001stPrime {


    private static void findPrime() {
        List<Integer> primes = new ArrayList<>();

        int currentPrime = 2, counter = 1;

        while (counter <= 10001) {
            if (isPrime(currentPrime)) {
                primes.add(currentPrime);
                currentPrime++;
                counter++;
            }
            else {
                currentPrime++;
            }
        }

        System.out.println(primes.get(10000));
    }


    private static boolean isPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }


    private static boolean primalityNaive(int num) {
        if (num < 2) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        // findPrime();
        System.out.println(primalityNaive(17));
    }
}
