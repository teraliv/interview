package com.interview.array;

import java.util.*;

/**
 * @author Alex Terikov
 * Date: 01/30/2019
 *
 * Find common elements in two sorted arrays.
 *
 * Time Complexity:
 * O(n + m) for solution using HashSet
 * O(min(n, m)) for solution using two pointers
 * where n - number of elements in first array, m - number of elements in second array.
 *
 * input:
 * A = [1, 3, 4, 6, 7, 9]
 * B = [1, 2, 4, 5, 9, 10]
 *
 * output:
 * [1, 4, 9]
 *
 */
public class CommonElementsInTwoSortedArrays {

    /**
     * Solution 1: using HahsSet
     *
     * step 1: add every element from array A to HashSet
     * step 2: check every element from array B if Set contains same element and add it to list of common elements.
     */
    private static List<Integer> findCommonElementsUsingSet(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) return null;

        Set<Integer>  set       = new HashSet<>();
        List<Integer> list    = new ArrayList<>();

        for (int i : arr1)
            set.add(i);

        for (int i : arr2) {
            if (set.contains(i))
                list.add(i);
        }

        return list;
    }


    /**
     * Solution: using two pointers
     *
     * step 1:  set pointer1 to first item in array A, set pointer2 to first item in Array B.
     * step 2:  iterate until pointer1 or pointer2 is less then the size of array.
     * step 3:  if elements at pointer1 == pointer2 add it to list and increment both pointers
     *          if element at pointer1 < element at pointer2 increment pointer1
     *          otherwise increment pointer2
     */

    private static List<Integer> findCommonElements(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) return null;

        List<Integer> list = new ArrayList<>(); // to hold common elements

        int p1 = 0; // pointer to first element in arr1
        int p2 = 0; // pointer to first element in arr2

        while(p1 < arr1.length && p2 <arr2.length) {
            if (arr1[p1] == arr2[p2]) {
                list.add(arr1[p1]);
                p1++;
                p2++;
            }
            else if (arr1[p1] < arr2[p2]) {
                p1++;
            }
            else {
                p2++;
            }
        }

        return list;
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6, 0, 9};
        int[] b = {1, 2, 4, 5, 9, 10};

        // List <Integer> common = findCommonElementsUsingSet(a, b);
        List<Integer> common = findCommonElements(a, b);

        for (Integer i : common)
            System.out.printf("%d ", i);
        System.out.println();

        int[] c = {1, 2, 5, 7, 8, 9};
        int[] d = {1, 3, 4, 7, 9, 12, 13, 15};

        common = findCommonElements(c, d);
        for (Integer i : common)
            System.out.printf("%d ", i);
    }
}
