package com.interview.leetcode;

/**
 * 268. Missing Number
 *
 * Given an array containing n distinct numbers taken from
 * 0, 1, 2, ..., n, find the one that is missing from the array.
 * Your algorithm should run in linear runtime complexity.
 *
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Logic:
     * 1. sum up indexes
     * 2. sum up elements in array
     * 3. the result is difference between sum of indexes and sum of array elements
     */
    public int findMissingNumber(int[] nums) {
        int i, sum1 = 0, sum2 = 0;
        for (i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            sum2 += i;
        }
        sum2 += i;

        return  sum2 - sum1;
    }


    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();

        int[] nums1 = {3,0,1};
        int[] nums2 = {9,6,4,2,3,5,7,0,1};

        System.out.println( mn.findMissingNumber(nums1) );
        System.out.println( mn.findMissingNumber(nums2) );
    }
}
