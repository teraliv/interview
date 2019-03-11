package com.interview.string;

/**
 * 43. Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    private String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int n = num1.length(), m = num2.length();
        int[] result = new int[n+m];    // will contain numeric result represented as array

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int a = num2.charAt(i) - '0';   // get numeric value from num2[i]
                int b = num1.charAt(j) - '0';   // get numeric value from num1[j]
                int sum = a * b + result[i+j+1];

                result[i+j]  += sum / 10;
                result[i+j+1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (result[0] != 0) sb.append(result[0]);
        for (int i = 1; i < result.length; i++)
            sb.append(result[i]);

        return sb.toString();
    }


    /**
     * Test cases:
     */
    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();

        System.out.println( ms.multiply("123", "456") );    // 56088
        System.out.println( ms.multiply("9", "9") );        // 81
        System.out.println( ms.multiply("925", "0") );      // 0

    }
}
