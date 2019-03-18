package com.interview.dynamic;

/**
 * 583. Delete Operation for Two Strings
 *
 *
 * Reference:
 * ---------
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 *
 * Approach: DP
 * Similar to Longest Common Subsequence
 *
 * Time/space complexity: O(nm), n = word1 length, m = word2 length
 */
public class DeleteOperationTwoStrings {

    private int minDistance(String word1, String word2) {
        int[][] results = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++)
            results[i][0] = i;

        for (int i = 1; i <= word2.length(); i++)
            results[0][i] = i;


        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    results[i][j] = results[i-1][j-1];
                else
                    results[i][j] = Math.min(results[i-1][j], results[i][j-1]) + 1;
            }
        }

        return results[word1.length()][word2.length()];
    }


    public static void main(String[] args) {
        DeleteOperationTwoStrings dots = new DeleteOperationTwoStrings();

        System.out.println( dots.minDistance("sea", "eat") );   // 2
        System.out.println( dots.minDistance("s", "") );        // 1
    }
}
