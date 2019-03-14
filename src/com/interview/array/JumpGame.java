package com.interview.array;

/**
 * 55. Jump Game
 * 45. Jump Game II
 *
 * https://leetcode.com/problems/jump-game/
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * Approach: Greedy - both problems
 */
public class JumpGame {

    /**
     * Solution:
     * 1. At every index record max possible jump.
     * 2. If last element is reachable (max >= last index) - we jumped to the end.
     * 3. If maximum jump is equal to current index position then end is not reachable.
     */
    private boolean canJump(int[] nums) {
        int max = 0;

        for (int i = 0;i < nums.length; i++) {
            max = Math.max(i + nums[i], max);       // record max possible jump
            if (max >= nums.length-1) return true;  // can jump to last index
            if (i == max) return false;             // end is not reachable
        }
        return true;
    }


    /**
     * Solution:
     * 1. Get the max we can jump from current position
     * 2. if current index i is the same as index of max - update steps and max index
     */
    private int jump(int[] nums) {
        int last = nums.length-1;
        int max = 0;    // current max we can jump
        int index = 0;  // index of max
        int steps = 0;  // steps counter

        for (int i = 0; i < last; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == index) {
                steps++;
                index = max;
            }
        }
        return steps;
    }


    /**
     * Test cases:
     */
    public static void main(String[] args) {
        JumpGame game = new JumpGame();

        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        int[] nums3 = {0};
        int[] nums4 = {3,2,1,1,4};
        int[] nums5 = {1,1,2,4,2};
        int[] nums6 = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

        // can jump
        System.out.println( game.canJump(nums1) ); // true
        System.out.println( game.canJump(nums2) ); // false
        System.out.println( game.canJump(nums3) ); // true

        // count steps to jump
        System.out.println( game.jump(nums1) ); // 2
        System.out.println( game.jump(nums3) ); // 0
        System.out.println( game.jump(nums4) ); // 2
        System.out.println( game.jump(nums5) ); // 3
        System.out.println( game.jump(nums6) ); // 2


    }
}
