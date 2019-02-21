package com.interview.string;

/**
 * @author Alex Terikov
 * Date: 01/30/2019
 *
 * Time complexity: O(n)
 *
 * One edit away is a string manipulation operation with following condition:
 * given original string:   "abcde"
 * 1: one char replaced:    "abfde"     -> true
 * 2: one char deleted:     "abde"      -> true
 * 3: one char added:       "abcdef"    -> true
 *
 * Any similar to the above 3 conditions will return true, any more modifications
 * with original string will return false.
 *                          "abxxde"    -> false
 *                          "abd"       -> false
 *                          "abcdefgh"  -> false
 */
public class OneEditAwayString {

    private static boolean isOneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;

        else if (s1.length() == s2.length())
            return isOneAwaySameLength(s1, s2);

        else if (s1.length() > s2.length())
            return isOneAwayDiffLength(s1, s2);

        else
            return isOneAwayDiffLength(s2, s1);
    }


    private static boolean isOneAwaySameLength(String s1, String s2) {
        int countDifference = 0;
        for (int i = 0; i < s1.length(); i++ ) {
            if (s1.charAt(i) != s2.charAt(i))
                countDifference++;
            if (countDifference > 1)
                return false;
        }
        return true;
    }


    private static boolean isOneAwayDiffLength(String s1, String s2) {
        int i = 0;
        int countDifference = 0;
        while (i < s2.length()) {
            if (s1.charAt(i + countDifference) != s2.charAt(i))
                countDifference++;
            else
                i++;

            if (countDifference > 1)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        // Test Cases
        System.out.println( isOneAway("abcde", "abcd") );   // true
        System.out.println( isOneAway("abde", "abcde") );   // true
        System.out.println( isOneAway("a", "a"));           // true
        System.out.println( isOneAway("abcdef", "abqdef")); // true
        System.out.println( isOneAway("abcdef", "abccef") );// true
        System.out.println( isOneAway("abcdef", "abcde") ); // true
        System.out.println( isOneAway("aaa", "abc") );      // false
        System.out.println( isOneAway("abcde", "abc") );    // false
        System.out.println( isOneAway("abc", "abcde") );    // false
        System.out.println( isOneAway("abc", "bcc") );      // false
        System.out.println( isOneAway("abcd", "abx") );     // false
    }
}
