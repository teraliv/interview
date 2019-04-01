package com.interview.string;

/**
 * 5. Longest Palindromic Substring
 *
 *
 * Reference:
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Time complexity:
 * Space complexity:
 *
 * Credit to @TusharRoy (github.com/mission-peace/interview)
 */
public class LongestPalindromicSubstring {

    /**
     * Manacher's Algorithm to find Longest Palindrome Substring.
     *
     * There are 4 cases to handle:
     * 1. Right side palindrome is totally contained under current palindrome. In this case do not consider this as center.
     * 2. Current palindrome expands till the end of input. Terminate the loop in this case. No better palindrome will be found on the right.
     * 3. Current palindrome expands till the right edge & it's left mirror palindrome is proper prefix. Choose its center as new center.
     * 4. Current palindrome expands till the right edge & it's mirror palindrome expands beyond the left edge. Do not consider as new center.
     *
     * To handle even size palindromes replace input string with one containing $ between every input character and in start and end.
     */
    private String longestPalindrome(String s) {

        // preprocess input string (abba -> #a#b#b#a#) so it will handle both even and odd size lengths
        char[] input = modifyInput(s);
        int[] result = new int[input.length]; // temp array to hold palindrome sizes

        int left = 0, right = 0;

        // while (i < input.length) {
        for (int i = 0; i < input.length;) {

            // expand palindrome by moving left and right characters util its equal
            while (left > 0 && right < input.length - 1 && input[left-1] == input[right+1]) {
                left--;
                right++;
            }

            // record current palindrome size
            result[i] = right - left + 1;

            // handle case 2, we have reached the end of input
            if (right == input.length - 1) {
                break;
            }

            // set new center to either right edge or right + 1, depending on input string is even or odd
            int center = right + (i % 2 == 0 ? 1 : 0);

            for (int j = i + 1; j <= right; j++) {
                int leftCenter = i - (j - i);           // i - (j - i) is the left center
                int distance   = 2 * (right - j) + 1;   // distance from j to right edge

                result[j] = Math.min(result[i - (j - i)], 2 * (right - j) + 1);
                // it is possible that left mirror palindrome expands beyond left edge, so we take minimum of either
                // left palindrome size or distance from j to left palindrome center.
                result[j] = Math.min(result[leftCenter], distance);

                // handle case 3. This checks to make sure we do not select j as a new center for case 1 and 4.
                if (j + result[leftCenter] / 2 == right) {
                    center = j;
                    break;
                }
            }

            // set i to a new center. Set left and right to the positions we already know,
            // so we star left and right from unexpanded sides.
            i = center;
            left  = i - result[i] / 2;
            right = i + result[i] / 2;
        }

        return largestPalindromeSize(result, input);
    }


    private char[] modifyInput(String s) {
        char[] newInput = new char[2 * s.length() + 1];

        for (int i = 0, j = 0; i < newInput.length; i++) {
            if (i % 2 == 0)
                newInput[i] = '#';
            else
                newInput[i] = s.charAt(j++);
        }
        return newInput;
    }


    /**
     * Find the largest palindrome number based on the given array.
     */
    private String largestPalindromeSize(int[] arr, char[] input) {
        int largest = 0, index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
                index = i;
            }
        }

        StringBuilder sb = new StringBuilder(largest/2);
        index = index / 2;

        for (int i = 0; i < largest; i++) {
            if (input[index] != '#')
                sb.append(input[index]);
            index++;
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

        // String str = "abaxabaxabybaxabyb";
        String str = "babad";

        System.out.println( lps.longestPalindrome(str) );
        // System.out.println( lps.longestPalindromicSubstringLinear(str.toCharArray()) );
        // System.out.println( lps.longestPalindromeDynamic(str.toCharArray()) );

    }
}
