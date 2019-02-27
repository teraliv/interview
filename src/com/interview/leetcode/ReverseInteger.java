package com.interview.leetcode;

/**
 * 7. Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    /**
     * Returns reverse number or 0 if reversed integer overflows.
     */
    public int reverse(int x) {
        int reverse = 0, remainder, num = Math.abs(x);

        while (num != 0) {
            remainder = num % 10;
            reverse   = reverse * 10 + remainder;
            // check integer overflow by comparing remainder and reverse last integer
            if (reverse  % 10 != remainder)
                return 0;
            num = num/10;
        }

        if (x < 0) return 0 - reverse;
        return reverse;
    }


    public static void main(String[] args) {
        ReverseInteger integer = new ReverseInteger();

        System.out.println(integer.reverse(123));
        System.out.println(integer.reverse(-521));
        System.out.println(integer.reverse(2147483647)); // 0
    }
}
