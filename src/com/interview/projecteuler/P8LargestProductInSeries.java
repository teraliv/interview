package com.interview.projecteuler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 8: Largest product in a series
 *
 * Reference
 * https://projecteuler.net/problem=8
 */
public class P8LargestProductInSeries {

    /**
     * Solution
     */
    private static void findLargestProduct() {
        List<Integer> digits = readDigitsFile();
        long result = 0L;

        for (int i = 0; i < digits.size() - 13; i++) {

            int upperBound = i + 13;
            long sum = 1L;

            for (int j = i; j < upperBound; j++)
                sum *= digits.get(j);

            result = (result < sum) ? sum : result;
        }

        System.out.println(result);
    }


    public static void main(String[] args) {
        findLargestProduct();
    }


    /**
     * Read text file
     */
    private static List<Integer> readDigitsFile() {
        Scanner scanner = null;
        List<Integer> digits = new ArrayList<>();

        try {

            scanner = new Scanner(new FileInputStream("digits.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                for (int i = 0; i < line.length(); i++) {
                    digits.add(Character.getNumericValue(line.charAt(i)));
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return digits;
    }
}
