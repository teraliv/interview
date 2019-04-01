package com.interview.dynamic;

/**
 * 62. Unique Paths
 * 63. Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths/
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * Time complexity: O(mn)
 * Space complexity: O(n)
 */
public class UniquePaths {

    /**
     * m = 3, n = 3
     *
     * +---+---+---+
     * | 1 | 1 | 1 |
     * +---+---+---+
     * | 1 | 2 | 3 |
     * +---+---+---+
     * | 1 | 3 | 6 |
     * +---+---+---+
     */
    private static int uniquePaths(int m, int n) {
        int[] paths = new int[m];
        paths[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                paths[j] = paths[j-1] + paths[j];
            }
        }

        return paths[m-1];
    }


    /**
     * +---+---+---+    +---+---+---+
     * | 0 | 0 | 0 |    | 1 | 1 | 1 |
     * +---+---+---+    +---+---+---+
     * | 0 | 0 | 0 | -> | 1 | 2 | 3 |
     * +---+---+---+    +---+---+---+
     * | 0 | 1 | 0 |    | 1 | 0 | 3 |
     * +---+---+---+    +---+---+---+
     */
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;

        int[] temp = new int[width];
        temp[0] = 1;

        // using DP approach calculate paths
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    temp[j] = 0;
                else if (j > 0)
                    temp[j] = temp[j] + temp[j-1];
            }
        }

        return temp[width-1];
    }


    /**
     * test cases
     */
    public static void main(String[] args) {

        System.out.println("Unique Paths I:");
        System.out.println( uniquePaths(7, 3) );    // 28
        System.out.println( uniquePaths(3, 2));     // 3

        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        System.out.println("Unique Paths II:");
        System.out.println( uniquePathsWithObstacles(grid) );
    }
}
