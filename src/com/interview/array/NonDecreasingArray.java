package com.interview.array;

/**
 * 665. Non-decreasing Array
 *
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (j != -1) return false;
                j = i;
            }

        }
        return j == -1 || j == 0 || j == nums.length-2 || nums[j-1] <= nums[j+1] || nums[j] <= nums[j+2];
    }


    public static void main(String[] args) {
        int[] nums1 = {4,2,3};      // true
        int[] nums2 = {4,2,1};      // false
        int[] nums3 = {3,4,2,3};    // false
        int[] nums4 = {2,3,3,2,4};  // true
        int[] nums5 = {1,2,3};      // true
        int[] nums6 = {1,2,4,5,3};  // true

        System.out.println( checkPossibility(nums1) );
        System.out.println( checkPossibility(nums2) );
        System.out.println( checkPossibility(nums3) );
        System.out.println( checkPossibility(nums4) );
        System.out.println( checkPossibility(nums5) );
        System.out.println( checkPossibility(nums6) );
    }
}
