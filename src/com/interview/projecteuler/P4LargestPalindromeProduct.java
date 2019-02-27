package com.interview.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Problem 4: Largest palindrome product
 *
 * Reference:
 * https://projecteuler.net/problem=4
 */
public class P4LargestPalindromeProduct {

    /**
     * Finds larges palindrome made from the product of two 3-digit numbers.
     * Example: 999 * 999
     */
    private static int findLargestPalinderome() {
        List<Integer> palindromes = new ArrayList<>();

        for (int i = 999; i > 99; i--) {
            for (int j = 999; j > 99; j--) {
                int product = i * j;
                if (isPalindrome(product)) {
                    palindromes.add(product);
                }
            }
        }

        return Collections.max(palindromes);
    }

    /**
     * Checks if a given number is palindrome
     */
    private static boolean isPalindrome(int num) {
        String numString = Integer.toString(num);
        Stack<Character> stack = new Stack<>();

        // fill stack
        for (int i = 0; i < numString.length(); i++) {
            stack.add(numString.charAt(i));
        }

        boolean palindrome = true;

        for (int i = 0; i < numString.length(); i++) {
            if (numString.charAt(i) != stack.pop()) {
                palindrome = false;
                break;
            }
        }

        return palindrome;
    }


    public static void main(String[] args) {
        System.out.println( findLargestPalinderome() );
    }
}
