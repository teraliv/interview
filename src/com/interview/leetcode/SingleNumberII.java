package com.interview.leetcode;

/**
 * 137. Single Number II
 *
 *
 * https://leetcode.com/problems/single-number-ii/
 *
 * Time complexity O(n)
 * Space complexity O(1) - no additional data storage is used.
 *
 * The solution is based on the following explanation:
 * https://www.careercup.com/question?id=7902674
 */
public class SingleNumberII {

    public int findSingleNumber(int[] nums) {

        int ones = 0, twos = 0, not_threes;

        for (int i : nums) {
            twos |= ones & i;
            ones ^= i;
            not_threes = ~(ones & twos);
            ones &= not_threes;
            twos &= not_threes;
        }

        return ones;
    }

    public static void main(String[] args) {
        SingleNumberII sn = new SingleNumberII();

        int[] nums1 = {2,2,3,2}; //3
        int[] nums2 = {0,1,0,1,0,1,99}; //99

        System.out.println( sn.findSingleNumber(nums1) );
        System.out.println( sn.findSingleNumber(nums2) );
    }
}
