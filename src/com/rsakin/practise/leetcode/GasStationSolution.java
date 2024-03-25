package com.rsakin.practise.leetcode;

public class GasStationSolution {


    // gas stations & costs for each road
    // 1.way - traversing all the stations by starting each station - brute force naive solution
    // 2 for loop, 1 for keeping the start station, 2nd for traversing all the other stations till gas tank is not empty
    // Time: O(n^2) , Space: O(1)

    // 2.way -- better efficient
    // gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    // -2, -2, -2, "3", "3"  -> it needs to be positive for being a possible starting point!
    // -2 -> -4 -> -6 -> -3 -> 0
    // then I need to find the change on the tank, if its positive currently, then it can be possible starting point

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If the tank becomes negative, reset startStation and tank
            if (tank < 0) {
                startStation = i + 1;
                tank = 0;
            }
        }

        // If total gas is less than total cost, it's impossible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }

        return startStation;
    }

    public static void main(String[] args) {
        GasStationSolution solution = new GasStationSolution();

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("Starting gas station index: " + solution.canCompleteCircuit(gas, cost)); // Output: 3
    }


}
