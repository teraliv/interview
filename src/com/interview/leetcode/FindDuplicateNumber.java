package com.interview.leetcode;

/**
 * 286. Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 *
 * Example:
 * Input:  [1,3,4,2,2]
 * Output: 2
 *
 * Note:
 * 1. You must not modify the array (assume the array is read only).
 * 2. You must use only constant, O(1) extra space.
 * 3. Your runtime complexity should be less than O(n2).
 * 4. There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        // Tortoise[slow] and Rabbit[fast] both will enter cycle and meet at some point.
        int slow = nums[0];
        int fast = nums[0];

        // Find intersection point of slow and fast
        do {
            slow = nums[slow];       // traverse normally
            fast = nums[nums[fast]]; // traverse 2x faster than slow
        } while (slow != fast);

        // Now tortoise[slow] and Rabbit[fast] move at the same speed
        // looking for the duplicate item - entrance to the loop
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        FindDuplicateNumber numbers = new FindDuplicateNumber();

        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};
        int[] nums3 = {2,2,2,2,2};
        int[] nums4 = {1,4,6,6,6,2,3};
        int[] nums5 = {2,5,9,6,9,3,8,9,7,1};

        System.out.println( numbers.findDuplicate(nums1) ); // 2
        System.out.println( numbers.findDuplicate(nums2) ); // 3
        System.out.println( numbers.findDuplicate(nums3) ); // 2
        System.out.println( numbers.findDuplicate(nums4) ); // 6
        System.out.println( numbers.findDuplicate(nums5) ); // 9
    }
}
