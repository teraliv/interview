package com.interview.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Reference:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Space complexity: in-place
 * Do not allocate extra space
 */
public class RemoveDuplicatesSortedArray {

    /**
     * Time complexity O(1)
     * Space complexity: in-place
     */
    public int removeDuplicates(int[] nums) {
        int replace = 0; // replace index and replaces counter

        for (int i = 0; i < nums.length - 1; i++) {
            // if new element was found
            if (nums[i] != nums[i+1]) {
                replace++;                  // increment replace index
                nums[replace] = nums[i+1];  // move next new element to replace position
            }
        }
        return ++replace;
    }

    /**
     * Implementation with HashSet to track duplicate items
     */
    public int removeDuplicatesHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int replace = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                if (replace != i) nums[replace] = nums[i];
                replace++;
            }
        }

        return replace;
    }


    /**
     * Test cases:
     * 1. random
     * 2. random
     * 3. same elements
     * 4. ascending elements
     */
    public static void main(String[] args) {
        RemoveDuplicatesSortedArray d = new RemoveDuplicatesSortedArray();

        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};        // 5
        int[] nums2 = {1,2,3,4,5,5,5,6,6,7,8};      // 8
        int[] nums3 = {2,2,2,2};                    // 1
        int[] nums4 = {1,2,3,4,5,6};                // 6

        System.out.println( d.removeDuplicates(nums1) );
        System.out.println( d.removeDuplicates(nums2) );
        System.out.println( d.removeDuplicates(nums3) );
        System.out.println( d.removeDuplicates(nums4) );
    }
}
