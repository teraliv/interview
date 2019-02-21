package com.interview.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex Terikov
 * Date: 01/30/2019
 *
 *
 * Find most frequently occurring item in array.
 *
 * input : [1, 3, 1, 3, 2, 1]
 * output : 1
 */
public class MostFrequentItemInArray {

    /**
     * Solution using HashMap
     * Time Complexity: o(n)
     */
    private static int mostFrequent(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        int mostFrequentCount = 0;
        int mostFrequentItem = 0;

        for (int i : arr) {
            if (occurrences.containsKey(i)) {
                occurrences.put(i, occurrences.get(i) + 1);
            }
            else
                occurrences.put(i, 1);

            if (mostFrequentCount < occurrences.get(i)) {
                mostFrequentCount = occurrences.get(i);
                mostFrequentItem = i;
            }
        }

        return mostFrequentItem;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 3, 2, 1};

        int max = mostFrequent(arr);
        System.out.printf("most frequent item: %d \n", max);

        int[] arr2 = {0, 0, 1, 1};
        max = mostFrequent(arr2);
        System.out.printf("most frequent item: %d \n", max);
    }
}
