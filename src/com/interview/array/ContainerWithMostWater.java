package com.interview.array;

/**
 * 11. Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    /**
     * The solution with 2 pointers left and right. Calculate area between
     * pointers and move pointer with lower value to the next element. If values
     * are the same in both pointers move pointer that contain greater value at
     * the next element.
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1; // left and right pointers
        int max = 0, area;

        while (left != right) {
            area = Math.min(height[left], height[right]) * (right - left); // calculate area
            max  = Math.max(max, area); // record max area result

            // move a pointer to next element
            if (height[left] < height[right])
                left++;
            else if (height[left] > height[right])
                right--;
            else {
                if (height[left+1] > height[right-1])
                    left++;
                else
                    right--;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();

        int[] heights1 = {1,8,6,2,5,4,8,3,7};

        System.out.println( container.maxArea(heights1) );
    }
}
