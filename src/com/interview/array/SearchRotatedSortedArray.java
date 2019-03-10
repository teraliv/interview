package com.interview.array;

/**
 * 33. Search in Rotated Sorted Array
 *
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Time complexity: O(logn)
 */
public class SearchRotatedSortedArray {

    private int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    /**
     * Binary search solution to find target in given array
     */
    private int binarySearch(int[] nums, int target, int start, int end) {
        int result = -1;
        if (start > end) return result; // left and right points crossed each other

        int mid = (start + end) / 2;    // mid point

        if (nums[mid] == target)
            return mid;
        else {
            // traverse left part
            result = binarySearch(nums, target, start, mid-1);

            // traverse the right part only if the result was not fount in left
            if (result == -1)
                result = binarySearch(nums, target, mid+1, end);
        }
        return result;
    }


    public static void main(String[] args) {
        SearchRotatedSortedArray rotated = new SearchRotatedSortedArray();

        int[] nums1 = {4,5,6,7,0,1,2};
        int[] nums2 = {2,5,6,0,0,1,2};

        System.out.println( rotated.search(nums1, 0) );
        System.out.println( rotated.search(nums2, 0) );
    }
}
