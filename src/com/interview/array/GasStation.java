package com.interview.array;

/**
 * 134. Gas Station
 *
 * https://leetcode.com/problems/gas-station/
 *
 * Approach: Greedy
 */
public class GasStation {

    /**
     * Solution:
     * Iterate over gas and cost
     * 1. calculate total amount of gas gathered and used.
     * 2. calculate current amount of gas - cost, if it less then 0 make starting station i + i
     *
     * @return - either starting point or -1
     */
    private int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;  // total amount of gas
        int curr  = 0;  // current tank amount
        int start = 0; // starting station

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            curr  += gas[i] - cost[i];
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return (total >= 0) ? start : -1;
    }


    /**
     * This method can find multiple starting points
     *
     * example:
     * [5,8,2,8]    output 0
     * [6,5,6,6]    expected 3, but both cases work
     */
    private int canCompleteCircuitMultiple(int[] gas, int[] cost) {
        int sum = 0, start = -1, max = 0;

        for (int i = 0; i < gas.length; i++) {
            int next = (i+1 < gas.length) ? i+1 : 0;
            sum += gas[i] - cost[i];

            if (max < gas[i] - cost[i] + gas[next]) {
                max = gas[i] - cost[i] + gas[next];
                start = i;
            }
        }

        if (sum < 0) return -1;
        return start;
    }


    /**
     * Test cases:
     */
    public static void main(String[] args) {
        GasStation station = new GasStation();

        // [5,1,2,3,4] // expected 4
        // [4,4,1,5,1]

        // both cases work
        // [5,8,2,8]    output 0
        // [6,5,6,6]    expected 3

        // [5,5,1,3,4] output 4
        // [8,1,7,1,1] expected 3

        int[] gas  = {7,1,0,11,4};
        int[] cost = {5,9,1,2,5};

        System.out.println( station.canCompleteCircuit(gas, cost) );
    }
}
