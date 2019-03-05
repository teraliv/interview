package com.interview.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8. String to Integer (atoi)
 *
 *
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public int myAtoi(String str) {
        Pattern pattern = Pattern.compile("(\\-?\\+?\\d+)");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String number = str.substring(matcher.start(), matcher.end());
            String before = str.substring(0, matcher.start());

            // any preceding non whitespace characters may occur
            for (char c : before.toCharArray()) {
                if (c != ' ') return 0;
            }

            // overflow may occur
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                return (number.startsWith("-")) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        StringToInteger atoi = new StringToInteger();

        System.out.println( atoi.myAtoi("42"));
        System.out.println( atoi.myAtoi("   -42"));
        System.out.println( atoi.myAtoi("-91283472332 with words"));
        System.out.println( atoi.myAtoi("words and 987"));
        System.out.println( atoi.myAtoi("+1"));
        System.out.println( atoi.myAtoi("-+1"));
    }
}
