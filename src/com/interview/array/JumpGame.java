package com.interview.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 55. Jump Game
 *
 * https://leetcode.com/problems/jump-game/
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Approach: Greedy
 */
public class JumpGame {

    private boolean canJump(int[] nums) {
        int max = 0;

        /**
         * Solution:
         * 1. At every index record max possible jump.
         * 2. If last element is reachable (max >= last index) - we jumped to the end.
         * 3. If maximum jump is equal to current index position then end is not reachable.
         */
        for (int i = 0;i < nums.length; i++) {
            max = (max > (i+ nums[i])) ? max : nums[i] + i;     // record max possible jump
            if (max >= nums.length-1) return true;              // can jump to last index
            if (i == max) return false;                         // end is not reachable
        }
        return true;
    }


    /**
     * Test cases:
     */
    public static void main(String[] args) {
        JumpGame game = new JumpGame();

        int[] nums1 = {2,3,1,1,4}; // true
        int[] nums2 = {3,2,1,0,4}; // false
        int[] nums3 = {0}; // true

        System.out.println( game.canJump(nums1) );
        System.out.println( game.canJump(nums2) );
        System.out.println( game.canJump(nums3) );
    }
}
