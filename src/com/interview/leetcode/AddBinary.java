package com.interview.leetcode;

import java.math.BigInteger;

/**
 * 67. Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * solved on: 02/21/2019
 */
public class AddBinary {

    private static String add(String a, String b) {
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);

        BigInteger sum = num1.add(num2);

        return sum.toString(2);
    }


    /**
     * Test Cases
     */
    public static void main(String[] args) {
        String num1 = add("11", "1");
        String num2 = add("1010", "1011");

        System.out.printf("%s \n", num1);
        System.out.printf("%s \n", num2);
    }

}
