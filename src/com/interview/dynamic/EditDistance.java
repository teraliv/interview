package com.interview.dynamic;

/**
 * 72. Edit Distance
 *
 * Reference:
 * https://leetcode.com/problems/edit-distance/
 * https://en.wikipedia.org/wiki/Edit_distance
 *
 *
 * Time/space complexity: O(mn), where m = word1 length, n = word2 length
 */
public class EditDistance {

    private int minDistance(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < result[0].length; i++)
            result[0][i] = i;

        for (int i = 1; i < result.length; i++)
            result[i][0] = i;


        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    result[i][j] = result[i-1][j-1];
                else
                    result[i][j] = 1 + min(result[i][j-1], result[i-1][j-1], result[i-1][j]);
            }
        }

        return result[word1.length()][word2.length()];
    }


    private int min(int a, int b, int c) {
        int i = Math.min(a, b);
        return Math.min(i, c);
    }


    /**
     * test cases
     */
    public static void main(String[] args) {
        EditDistance distance = new EditDistance();

        System.out.println( distance.minDistance("horse", "ros"));              // 3
        System.out.println( distance.minDistance("intention", "execution"));    // 5
    }
}
