package com.interview.leetcode;

/**
 * 136. Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Reference:
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    /**
     * Solution using Bitwise XOR operator.
     * Using XOR operator will help to eliminate same numbers.
     *
     * XOR Example:
     * 4   = 0 1 0 0    3   = 0 0 1 1
     * 4   = 0 1 0 0    2   = 0 0 1 0
     * XOR = 0 0 0 0    XOR = 0 0 0 1
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }


    /**
     * Test cases:
     */
    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();

        int[] nums1 = {4,1,2,1,2};
        int[] nums2 = {2,2,1};

        System.out.println( sn.singleNumber(nums1) );
        System.out.println( sn.singleNumber(nums2) );
    }
}
