package com.interview.leetcode;


/**
 * 845. Longest Mountain in Array
 *
 * https://leetcode.com/problems/longest-mountain-in-array/description/
 *
 */
public class LongestMountainInArray {

    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;

        int size = 0, longest = 0;   // mountain size
        boolean start = false, cont = false, end = false;

        for (int i = 0; i < arr.length; i++) {
            if (!cont) start = mountainStarts(arr, i); // check mountain start

            // continue check mountain
            if (cont) {
                size++;
                end = mountainEnds(arr, i); // check mountain end
                if (end) {
                    longest = (size > longest) ? size : longest;
                    cont = false;
                    start = mountainStarts(arr, i);
                }
                if (mountainTopFlat(arr, i)) {
                    cont = false;
                    start = false;
                    size = 0;
                }
            }

            if (start && !cont) {
                size = 0;
                size++;
                cont = true;
            }
        }

        return longest;
    }

    private boolean mountainStarts(int[] arr, int i) {
        if (i == 0)
            return (arr[i] < arr[i+1]);
        else if (i == arr.length - 1)
            return false;
        else
            return (arr[i-1] >= arr[i] && arr[i] < arr[i+1]);
    }

    private boolean mountainEnds(int[] arr, int i) {
        if (i == arr.length - 1)
            return (arr[i-1] > arr[i]);
        else
            return (arr[i-1] > arr[i] && arr[i] <= arr[i+1]);
    }

    private boolean mountainTopFlat(int[] arr, int i) {
        return (arr[i-1] == arr[i]);
    }


    public static void main(String[] args) {
        LongestMountainInArray mt = new LongestMountainInArray();

        int[] arr1 = {2, 1, 4, 7, 3, 2, 5}; // 5
        int[] arr2 = {2, 2, 2}; // 0
        int[] arr3 = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}; // 11
        int[] arr4 = {1, 2, 3, 4, 3, 2, 2, 2, 3, 2, 1, 1}; //6
        int[] arr5 = {2,3,3,2,0,2};

        int result1 = mt.longestMountain(arr1);
        int result2 = mt.longestMountain(arr2);
        int result3 = mt.longestMountain(arr3);

        System.out.println(mt.longestMountain(arr5));

        // System.out.println(result1);
        // System.out.println(result2);
        // System.out.println(result3);
    }
}
