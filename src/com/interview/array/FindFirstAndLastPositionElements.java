package com.interview.array;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionElements {


    public int[] searchRange(int[] nums, int target) {
        int pos = findTargetPosition(nums, target, 0, nums.length-1);
        int length = nums.length - 1;

        if (pos == -1)
            return new int[]{-1,-1};
        else {
            int i = pos, j = pos;
            while ( (i > 0 && nums[i-1] == target) || (j < length && nums[j+1] == target) ) {
                i = (i > 0 && nums[i-1] == target) ? --i : i;
                j = (j < length && nums[j+1] == target) ? ++j : j;
            }

            return new int[]{i,j};
        }
    }


    /**
     * Recursively finds target position in a given array
     */
    private int findTargetPosition(int[] nums, int target, int left, int right) {
        int result;
        int mid = (right + left) / 2;

        if (left > right)
            result = -1;
        else if (nums[mid] == target)
            result = mid;
        else if (nums[mid] > target)
            result = findTargetPosition(nums, target, 0, mid-1);
        else
            result = findTargetPosition(nums, target, mid+1, right);

        return result;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        FindFirstAndLastPositionElements fl = new FindFirstAndLastPositionElements();

        int[] nums1 = {5,7,7,8,8,10};
        // int[] num2 = {1};
        int[] nums3 = {3,3,3};
        int[] result = fl.searchRange(nums3, 3);

        for (int i : result)
            System.out.println(i);
    }
}
