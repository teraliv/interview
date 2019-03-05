package com.interview.array;

/**
 * 845. Longest Mountain in Array
 *
 * https://leetcode.com/problems/longest-mountain-in-array/
 */
public class PeakElement {

    public int longestMountain(int[] arr) {
        int base = 0, end, length = arr.length, longest = 0;

        while (base < arr.length) {
            end = base;
            // mountain start
            if (end+1 < length && arr[end] < arr[end+1]) {
                // find peak of the mountain
                while (end+1 < length && arr[end] < arr[end+1]) {
                    end++;
                }
                // find the end of the mountain
                while (end+1 < length && arr[end] > arr[end+1]) {
                    end++;
                    int distance = end - base + 1;
                    longest = (distance > longest) ? distance : longest; // record longest distance
                }
                base = end;
            }
            else
                base++;
        }
        return longest;
    }



    public static void main(String[] args) {
        PeakElement pe = new PeakElement();


        int[] arr1 = {1,2,3,2,1,0,2,3,1}; // 6
        int[] arr2 = {1, 2, 1, 3, 5, 6, 4}; // 5
        int[] arr3 = {1,2,3,4,4,5,3}; // 3
        int[] arr4 = {2,2,2}; // 0 - Flat
        int[] arr5 = {1,2,3}; // 0 - Strictly increasing
        int[] arr6 = {3,2,1}; // 0 - Strictly decreasing

        System.out.println( pe.longestMountain(arr1) );
        System.out.println( pe.longestMountain(arr2) );
        System.out.println( pe.longestMountain(arr3) );
        System.out.println( pe.longestMountain(arr4) );
        System.out.println( pe.longestMountain(arr5) );
        System.out.println( pe.longestMountain(arr6) );

    }
}
