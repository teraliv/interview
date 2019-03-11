package com.interview.array;

/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Time Complexity: O(logn)
 */
public class FindMinimumRotatedSortedArray {

    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];

        while (left != right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid+1])
                return nums[mid+1];

            if (nums[mid] < nums[mid-1])
                return nums[mid];

            // go to right part
            if (nums[mid] > nums[right])
                left  = mid + 1;
            // go to left part
            else
                right = mid - 1;
        }
        return -1;
    }


    /**
     * Test cases:
     */
    public static void main(String[] args) {
        FindMinimumRotatedSortedArray rotated = new FindMinimumRotatedSortedArray();

        int[] nums1 = {4,5,6,7,0,1,2};
        int[] nums2 = {2,1};
        int[] nums3 = {1,2,3};
        int[] nums4 = {3,4,5,6,1,2};
        int[] nums5 = {5,6,7,8,9,1,2,3,4};

        System.out.println( rotated.findMin(nums1) );
        System.out.println( rotated.findMin(nums2) );
        System.out.println( rotated.findMin(nums3) );
        System.out.println( rotated.findMin(nums4) );
        System.out.println( rotated.findMin(nums5) );
    }
}
