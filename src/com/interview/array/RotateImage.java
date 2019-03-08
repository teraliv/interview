package com.interview.array;

/**
 * 48. Rotate Image - Rotate 2D Array
 *
 * https://leetcode.com/problems/rotate-image/
 *
 * Time complexity:  O(n^2)
 * Space complexity: O(1)
 */
public class RotateImage {

    /**
     * Rotate 2d array layer by layer starting by outermost layer going inwards;
     * Layers: TOP, LEFT, RIGHT, BOTTOM
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int end = n - 1;

        for (int layer = 0; layer < n/2; layer++) {

            int last = end - layer;
            for (int i = layer; i < last; i++) {
                int temp = matrix[layer][i];

                // TOP <- LEFT
                matrix[layer][i] = matrix[end-i][layer];

                // LEFT <- BOTTOM
                matrix[end-i][layer] = matrix[last][end-i];

                // BOTTOM <- RIGHT
                matrix[last][end-i] = matrix[i][last];

                // RIGHT <- temp
                matrix[i][last] = temp;
            }
        }
    }



    public static void main(String[] args) {
        RotateImage ri = new RotateImage();

        int[][] arr = {
                {7, 1,  4,  2},
                {5, 8,  6,  11},
                {0, 15, 12, 14},
                {9, 18, 17, 3}
        };

        System.out.println("Original Image");
        ri.print(arr);

        ri.rotate(arr);

        System.out.println("Rotated Image");
        ri.print(arr);

    }


    /**
     * prints 2d array
     */
    private void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
