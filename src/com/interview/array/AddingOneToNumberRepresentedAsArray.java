package com.interview.array;

/**
 * @author Alex Terikov
 * Date: 01/29/19
 *
 * Given a non-negative number represented as an array of digits,
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * Example:
 * Input :  [1, 2, 4]
 * Output : [1, 2, 5]
 */
public class AddingOneToNumberRepresentedAsArray {

    /**
     * Solving using only math operations.
     *
     * Time Complexity: O(n)
     *
     *
     * Example:
     * step 1: from the back of array multiply each element by multiple of 10 and sum it.
     * 4 * 1 = 4
     * 2 * 10 = 20
     * 1 * 100 = 100
     * sum = 124
     *
     * step 2: calculate the number of digits in sum by using log10 and round it up.
     * Math.log10(sum) + 1
     * Math.log10(125) + 1 = 3
     *
     * step 3: using modulus operator separate each digit and add it to output array
     * 125 % 10 = 5
     * 12 % 10 = 2
     * 1 % 10 = 1
     */
    private static int[] solveUsingMath(int[] arr) {

        int arrValue = 0;
        int multipleOfTen = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            arrValue += (arr[i] * multipleOfTen);
            multipleOfTen *= 10;
        }

        arrValue = arrValue + 1;

        // if we take their log in base 10 and round it up then we’ll get the number of digits in that number
        int length = (int) Math.log10(arrValue) + 1;

        int[] output = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            output[i] = arrValue % 10;
            arrValue /= 10;
        }

        return output;
    }


    /**
     * Solving using string methods.
     */
    private static int[] solveUsingStrings(int[] arr) {
        String sumString = "";

        for (int i = 0; i < arr.length; i++) {
            sumString += arr[i];
        }

        int arrValue = Integer.valueOf(sumString);

        arrValue = arrValue + 1;

        sumString = Integer.toString(arrValue);

        int[] output = new int[sumString.length()];

        for (int i = 0; i < sumString.length(); i++) {
            output[i] = Character.getNumericValue(sumString.charAt(i));
        }

        return output;
    }


    public static void main(String[] args) {
        int[] input1 = {1, 2, 4, 4};
        int[] input2 = {9, 9, 9, 9};
        int[] output1 = solveUsingMath(input1);
        int[] output2 = solveUsingMath(input2);

        System.out.println("solving using math operations:");
        for (int i : output1)
            System.out.print(i + " ");

        System.out.println();
        for (int i : output2)
            System.out.print(i + " ");

        System.out.println();
        System.out.println("solving using strings:");
        int[] output3 = solveUsingStrings(input1);
        for (int i : output3)
            System.out.print(i + " ");
    }
}
