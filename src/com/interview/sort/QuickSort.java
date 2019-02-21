package com.interview.sort;

/**
 * QuickSort Algorithm
 *
 * Time Complexity - (Avg - O(nlogn)), (Worst - O(n^2))
 * Space Complexity - In Place algorithm
 */
@SuppressWarnings("Duplicates")
public class QuickSort {


    /**
     * Sort recursively
     * @param arr - input array
     * @param start - start position
     * @param end - end position
     */
    private void sort(int[] arr, int start, int end) {
        if (start >= end) return;   // base case
        int partitionIndex = partition(arr, start, end);    // partition array

        sort(arr, start, partitionIndex - 1);    // sort recursively left part
        sort(arr, partitionIndex + 1, end);     // sort recursively right part
    }


    /**
     * Select pivot elements and rearrange all elements smaller than pivot to the left of pivot
     * and all elements greater than pivot to the right.
     *
     * Pivot is the last element.
     *
     * @param arr - input array
     * @param start - start position
     * @param end - end position
     */
    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int partitionIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, end);

        return partitionIndex;
    }


    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

        int[] arr1 = {5, 1, 3, 6, 2, 4, 7, 9};
        int[] arr2 = {8, 7};
        int[] arr3 = {3};
        int[] arr4 = new int[4];
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr6 = {6, 5, 4, 3, 2, 1};
        int[] arr7 = {-1, -5, -2, -4, -7};

        qs.sort(arr1);
        qs.sort(arr2);
        qs.sort(arr3);
        qs.sort(arr4);
        qs.sort(arr5);
        qs.sort(arr6);
        qs.sort(arr7);

        qs.print(arr1);
        qs.print(arr2);
        qs.print(arr3);
        qs.print(arr4);
        qs.print(arr5);
        qs.print(arr6);
        qs.print(arr7);
    }


    //HELPER METHODS
    private void sort(int[] arr) {
        int start = 0, end = arr.length - 1;
        sort(arr, start, end);
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
