package com.interview.string;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex Terikov
 * Date: 01/30/2019
 *
 * Find non repeating character in the given string.
 * Time Complexity: O(n)
 */
public class NonRepeatingCharacter {

    /**
     * Finds and returns non repeating character in given array
     * or null if such character is not found.
     */
    private static Character nonRepeatingChar(String str) {
        if (str.length() == 0) return null;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1)
                return c;
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(nonRepeatingChar("aabcb"));
        System.out.println(nonRepeatingChar("abcdef"));
        System.out.println(nonRepeatingChar("aabb"));
    }
}
