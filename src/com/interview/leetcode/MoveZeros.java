package com.interview.leetcode;

/**
 * 283. Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/
 *
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 *
 * Time Complexity: O(n)
 * Space Complexity: in-place
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count++;
            else {
                if (count > 0) {
                    nums[i - count] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    /**
     * Test Cases
     */
    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();

        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {0, 1, 5, 2, 0, 4, 0, 3};

        mz.moveZeroes(nums1);
        mz.moveZeroes(nums2);

        mz.print(nums1);
        mz.print(nums2);
    }

    private void print(int[] arr) {
        for (int i : arr)
            System.out.printf("%d ", i);
        System.out.println();
    }
}
