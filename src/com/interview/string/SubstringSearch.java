package com.interview.string;

/**
 * Substring Search
 *
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/
 */
public class SubstringSearch {

    /**
     * Knuth-Morris-Pratt (KMP) substring search
     *
     * Time Complexity: O(n+m), where n - text size, and m - pattern size
     */
    public int kmp(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);

        int i = 0, j = 0; // pointers: i - text, j - pattern

        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else {
                if (j == 0)
                    i++;
                else
                    j = lps[--j];
            }

        }

        if (j == pattern.length()) return i - j;

        return -1;
    }

    /**
     * KMP algorithm preprocess pattern and constructs an auxiliary array of
     * size m (size of pattern) which is used to skip characters while matching.
     *
     * Example:
     * pattern: "abcaby"
     * have prefix "ab" and suffix "ab"
     *
     * Time/Space complexity O(m)
     */
    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];

        int j = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j))
                lps[i++] = ++j;
            else {
                if (j == 0)
                    i++;
                else
                    j = lps[j-1];
            }
        }
        return lps;
    }


    /**
     * Slow naive algorithm to find substring match
     * Time complexity O(nm) where n - text length, m - pattern length
     */
    public int searchBruteForce(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int size = n - m;

        for (int i = 0; i <= size; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == m) return i; // found
        }
        return -1; // not fount
    }


    /**
     * Test cases
     */
    public static void main(String[] args) {
        SubstringSearch ss = new SubstringSearch();

        // Test lps prefix - suffix array build
        // int[] lps1 = ss.computeLPSArray("abcaby"); // [0,0,0,1,2,0]
        // int[] lps2 = ss.computeLPSArray("acacabacacabacacac"); // [0,0,1,2,3,0,1,2,3,4,5,6,7,8,9,10,11,4]

        // test KMP substring search algorithm
        int result1 = ss.kmp("abxabcabcaby", "abcaby"); // 6
        int result2 = ss.kmp("abcxabcdabxabcdabcdabcy", "abcdabcy"); // 15
        int result3 = ss.kmp("abcdefghk", "aa"); // -1

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    private void print(int[] arr) {
        for (int i : arr)
            System.out.printf("%d ", i);
        System.out.println();
    }
}
