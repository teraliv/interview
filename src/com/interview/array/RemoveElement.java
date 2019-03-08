package com.interview.array;

/**
 * 27. Remove Element
 *
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int count = 0, length = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val)
                count++;
            else {
                nums[i-count] = nums[i];
                length++;
            }
        }
        return length;
    }


    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();

        int[] nums = {0,1,2,2,3,0,4,2};

        System.out.println( re.removeElement(nums, 2) ); // length 5

    }
}
