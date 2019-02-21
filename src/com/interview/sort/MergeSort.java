package com.interview.sort;

/**
 * Merge Sort algorithm.
 *
 * Time complexity: O(nlogn)
 *
 *
 */
@SuppressWarnings("Duplicates")
public class MergeSort {

    /**
     * Sort recursively
     */
    public void sort(int[] orig) {
        if (orig.length == 1) return;   // base case

        int mid = orig.length / 2;      // split array by half

        int[] left  = new int[mid];                 // left part
        int[] right = new int[orig.length - mid];   // right part

        // copy left part
        for (int i = 0; i < mid; i++)
            left[i] = orig[i];

        // copy right part
        for (int i = mid; i < orig.length; i++)
            right[i - mid] = orig[i];

        sort(left); // sort recursively left part
        sort(right);// sort recursively right part
        merge(left, right, orig); // merge it
    }


    /**
     * Merges two arrays into original
     */
    private void merge(int[] left, int[] right, int[] orig) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                orig[k] = left[i];
                i++;
            }
            else {
                orig[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            orig[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            orig[k] = right[j];
            j++;
            k++;
        }
    }


    /**
     * Test Cases:
     * case 1: random numbers
     * case 2: 2 elements
     * case 3: 1 element
     * case 4: empty array - zeros
     * case 5: presorted
     * case 6: reverse sorted
     * case 7: negative numbers
     */
    public static void main(String[] args) {
        int[] arr1 = {5, 1, 3, 6, 2, 4, 7, 9};
        int[] arr2 = {8, 7};
        int[] arr3 = {3};
        int[] arr4 = new int[4];
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr6 = {6, 5, 4, 3, 2, 1};
        int[] arr7 = {-1, -5, -2, -4, -7};

        MergeSort merge = new MergeSort();

        merge.sort(arr1);
        merge.sort(arr2);
        merge.sort(arr3);
        merge.sort(arr4);
        merge.sort(arr5);
        merge.sort(arr6);
        merge.sort(arr7);

        print(arr1);
        print(arr2);
        print(arr3);
        print(arr4);
        print(arr5);
        print(arr6);
        print(arr7);
    }


    /**
     * prints array data
     */
    private static void print(int[] orig) {
        for (int i : orig)
            System.out.printf("%d ", i);
        System.out.println();
    }
}
