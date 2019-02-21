package com.interview.leetcode;

/**
 * @author Alex Terikov
 * Date: 01/31/2019
 *
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 *
 * A peak element is an element that is greater than its neighbors.
 */
public class PeakElement {

    /**
     * A naive solution to find peak element in given array.
     * Time complexity: O(n)
     */
    private static int findPeakElementNaive(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            int left = nums[i - 1];
            int right = nums[i + 1];

            if (left < nums[i] && nums[i] > right) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        else if (nums.length == 2)
            return (nums[0] < nums[1] ? 1 : 0);
        else if (nums.length == 3) {
            if (nums[0] > nums[1]) return 0;
            else if (nums[2] > nums[1]) return 2;
            else return 1;
        }

        int i = 1, current, left, right;

        while (i < nums.length - 1) {
            left = nums[i-1];
            current = nums[i];
            right = nums[i+1];

            if (left < current && current > right)
                return i;
            else if (current > right)
                i+=2;
            else
                i++;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,1,3,5,6,4};
        int[] nums2 = {1};
        int[] nums3 = {2,1};

        System.out.println( findPeakElement(nums1) );
        System.out.println( findPeakElement(nums2) );
        System.out.println( findPeakElement(nums3) );
    }
}
