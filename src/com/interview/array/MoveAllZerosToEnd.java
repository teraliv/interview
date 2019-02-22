package com.interview.array;

/**
 * @author Alex Terikov
 * Date: 01/30/2019
 *
 * Given an array of integers, move all of the zeros to the end of the array and
 * keep the other numbers in the same order they were in before.
 *
 * Time complexity: O(n)
 * Space complexity: O(n)M
 *
 * Example:
 * input:  [0, 1, 5, 2, 0, 4, 0, 3]
 * output: [1, 5, 2, 4, 3, 0, 0, 0]
 */
public class MoveAllZerosToEnd {


    /**
     * In-Place solution to move all zeros to the end of the array.
     *
     * Solution:
     * loop through array, if current element is zero -> count it, else if
     * current element is non zero move it toward the front of array counted times.
     */
    private static int[] moveZeros(int[] arr) {

        int zerosCount = 0;

        for (int i = 0; i < arr.length; i++) {

            // if current element is zero, then just update count of zeros.
            if (arr[i] == 0)
                zerosCount++;
            // else move it to to front of array zeroCount times.
            else {
                arr[i - zerosCount] = arr[i];
                arr[i] = 0;
            }
        }

        return arr;
    }



    public static void main(String[] args) {
        int[] arr = {0, 1, 5, 2, 0, 4, 0, 3};
        arr = moveZeros(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

}
