package com.interview.sort;

/**
 * Insertion Sort algorithm
 *
 * Time complexity:     O(n^2)  - worst, average : O(n) - best, if array is presorted
 * Space complexity:    O(1)    - in-place
 */
@SuppressWarnings("Duplicates")
public class InsertionSort {

    private void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }


    public static void main(String[] args) {
        InsertionSort insertion = new InsertionSort();

        int[] nums1 = {100, 34, 54, 12, 9};
        int[] nums2 = {5, 1, 3};
        int[] nums3 = {5, 1};
        int[] nums4 = {1};

        insertion.sort(nums1);
        insertion.sort(nums2);
        insertion.sort(nums3);
        insertion.sort(nums4);

        print(nums1);
        print(nums2);
        print(nums3);
        print(nums4);
    }


    private static void print(int[] arr) {
        for (int i : arr)
            System.out.printf("%d ", i);
        System.out.println();
    }
}
