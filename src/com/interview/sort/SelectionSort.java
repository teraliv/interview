package com.interview.sort;

/**
 * Selection Sort algorithm.
 *
 * Time Complexity:     O(n^2)  - best, average, worst.
 * Space complexity:    O(1)    - in-place solution.
 *
 * https://en.wikipedia.org/wiki/Selection_sort
 */
@SuppressWarnings("Duplicates")
public class SelectionSort {

    private void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // find next min element
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min]) min = j; // compare the numbers

            // swap only if new min was found
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }


    private void sortRecursively(int pos, int[] arr) {
        if (pos < arr.length - 1) {
            int min = pos;
            for (int j = pos + 1; j < arr.length; j++)
                if (arr[j] < arr[min]) min = j;

            // swap elements
            if (min != pos) {
                int temp = arr[pos];
                arr[pos] = arr[min];
                arr[min] = temp;
            }
            sortRecursively(pos + 1, arr);
        }
    }


    public static void main(String[] args) {
        SelectionSort selection = new SelectionSort();

        // test cases
        int[] nums0 = {100, 34, 54, 12, 9}; // for recursive method
        int[] nums1 = {100, 34, 54, 12, 9};
        int[] nums2 = {5, 1, 3};
        int[] nums3 = {4, 2};
        int[] nums4 = {1};

        selection.sort(nums1);
        selection.sort(nums2);
        selection.sort(nums3);
        selection.sort(nums4);

        print(nums1);
        print(nums2);
        print(nums3);
        print(nums4);

        System.out.println("sort recursively:");
        selection.sortRecursively(0, nums0);
        print(nums0);
    }


    private static void print(int[] arr) {
        for (int i : arr)
            System.out.printf("%d ", i);
        System.out.println();
    }

}
