package com.interview.array;

/**
 * 53. Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    /**
     * Dynamic Programming solution
     * Time complexity: O(n)
     */
    private int maxSubArray(int[] nums) {
        int max  = nums[0]; // global max
        int curr = nums[0]; // current max

        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max  = Math.max(curr, max);
        }
        return max;
    }


    /**
     * test cases
     */
    public static void main(String[] args) {
       MaximumSubarray ms = new MaximumSubarray();

       int[] nums1 = {-2,-3,4,-1,-2,1,5,-3};

        System.out.println( ms.maxSubArray(nums1) );
    }

}
