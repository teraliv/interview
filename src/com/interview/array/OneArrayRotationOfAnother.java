package com.interview.array;

/**
 * @author Alex Terikov
 * Date: 01/30/2019
 *
 * Find if one array is rotation of another.
 * Time complexity: O(n)
 */
public class OneArrayRotationOfAnother {


    private static boolean isRotation(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        int pos = 0; // will contain an index position of first common element in arr2

        // iterate until the end of second array is reached or common element is found.
        while (pos < arr2.length && arr1[0] != arr2[pos]) pos++;

        // no common elements were found
        if (arr1[0] != arr2[pos]) return false;

        // compare all elements in both arrays
        for (int i = 0; i < arr1.length; i++) {
            // find correct index for arr2
            int index =  (pos + i) % arr1.length;

            if (arr1[i] != arr2[index])
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {4, 5, 6, 7, 1, 2, 3};
        int[] c = {1, 2, 3, 4, 5, 6, 8};
        int[] d = {5, 6, 7, 8};

        System.out.println(isRotation(a, b));
        System.out.println(isRotation(a, c));
        System.out.println(isRotation(a, d));
    }
}
