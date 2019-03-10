package com.interview.array;

/**
 * 35. Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/
 *
 * Time complexity: O(n)
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int i = 0;

        while (nums[i] <= target && i < nums.length-1) {
            if (nums[i] == target) return i;
            i++;
        }

        if (nums[i] < target) return i+1;

        return i;
    }


    /**
     * Test cases
     */
    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();

        int[] nums1 = {1,3,5,6};

        System.out.println( sip.searchInsert(nums1, 5) ); // 2
        System.out.println( sip.searchInsert(nums1, 2) ); // 1
        System.out.println( sip.searchInsert(nums1, 7) ); // 4
        System.out.println( sip.searchInsert(nums1, 0) ); // 0
    }
}
