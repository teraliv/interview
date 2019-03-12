package com.interview.array;

/**
 * 66. Plus One
 *
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int[] arr = new int[digits.length];

        int n           = digits.length - 1;
        int remainder   = (digits[n] + 1) / 10;
        arr[n]          = (digits[n] + 1) % 10;


        for (int i = n - 1; i >= 0; i--) {
            int sum = (digits[i] + remainder);
            arr[i]      = sum % 10;
            remainder   = sum / 10;

        }
        if (remainder != 0) {
            int[] big = new int[digits.length+1];
            big[0] = 1;
            return big;
        }

        return arr;
    }


    public static void main(String[] args) {
        PlusOne po = new PlusOne();

        int[] digits = {9,9,9,9};
        int[] digitsPlusOne = po.plusOne(digits);

        for (int i : digitsPlusOne)
            System.out.printf("%d ", i);
    }
}
