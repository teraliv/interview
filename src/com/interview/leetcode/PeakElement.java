package com.interview.leetcode;

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Date: 02/22/2019
 *
 * Time Complexity - O(logn)
 */
public class PeakElement {


    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }


    /**
     * Divide & Conquer algorithm approach to find peak element in array.
     * 1. Find mid element of input array.
     * 2. If mid element is peak return it. Else:
     * 3. If mid element is less than right neighbor - split it from mid to end and repeat approach.
     * 4. Else if mid element is less than left neighbor - split it from first element to mid
     *    and repeat approach.
     */
    private int findPeakElement(int[] nums, int start, int end) {
        // check 1 element array
        if (nums.length == 1)
            return 0;

        // find mid element
        int mid = (end + start) / 2;

        if ( isPeak(nums, mid) ) {
            return mid;
        }
        else if (nums[mid] < nums[mid + 1]) {
            mid = findPeakElement(nums, mid+1, end);
        }
        else {
            mid = findPeakElement(nums, start, mid-1);
        }

        return mid;
    }


    /**
     * Helper function to test if given element is peak.
     */
    private boolean isPeak(int[] nums, int mid) {
        int left  = mid - 1;
        int right = mid + 1;

        // check if peak the left most element
        if (left < 0) {
            return nums[mid] > nums[right];
        }
        // check if peak the right most element
        else if (right >= nums.length) {
            return nums[mid] > nums[left];
        }
        // check both left and right elements
        else {
            return nums[left] < nums[mid] && nums[mid] > nums[right];
        }
    }


    /**
     * Test Cases:
     * 1. Random numbers
     * 2. 1 element in array
     * 3. 2 elements in array
     * 4. peak is the right most element
     * 5. peak is left most element
     */
    public static void main(String[] args) {
        PeakElement pe = new PeakElement();

        int[] nums1 = {1, 2, 1, 3, 5, 6, 4};
        int[] nums2 = {1};
        int[] nums3 = {1, 2};
        int[] nums4 = {1, 2, 3};
        int[] nums5 = {3, 2, 1};

        int peak1 = pe.findPeakElement(nums1);
        int peak2 = pe.findPeakElement(nums2);
        int peak3 = pe.findPeakElement(nums3);
        int peak4 = pe.findPeakElement(nums4);
        int peak5 = pe.findPeakElement(nums5);

        System.out.println(peak1);
        System.out.println(peak2);
        System.out.println(peak3);
        System.out.println(peak4);
        System.out.println(peak5);
    }
}
