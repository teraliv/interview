package com.interview.dynamic;

/**
 * 62. Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/
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
     * test cases
     */
    public static void main(String[] args) {

        System.out.println( uniquePaths(7, 3) );    // 28
        System.out.println( uniquePaths(3, 2));     // 3
    }
}
