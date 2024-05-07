package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class MinSubArrayLengthSolution {

    // 1.way for a naive solution is brute force approach
    // we can try all sublists to be sure whether it provides the best solution or not
    // For this solution we need 2 for loop nested so -> Time O(n^2)


    // 2.way for more efficient solution we can use sliding window approach
    // While moving on the list, we can get all elements to be equal or greater to target but if we are greater at that point,
    // we can check that is it possible to remove first element to make sub array narrower
    // so it takes just O(n) time to solve the problem
    public int minSubArrayLen(int target, int[] nums) {

        // {{2, 3, 1, 2, 4, 3}, {7}}
        // 2, 3, 1, 2

        // we can keep start index
        int sum = 0, startingInd = 0, minLength = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum - nums[startingInd] >= target) {
                sum -= nums[startingInd];
                startingInd++;
            }
            if (sum >= target) {
                minLength = Math.min(i - startingInd + 1, minLength);
            }
        }

        return minLength != nums.length + 1 ? minLength : 0;
    }

    public static void main(String[] args) {
        MinSubArrayLengthSolution solution = new MinSubArrayLengthSolution();

        // Test cases
        int[][][] testCases = {
                {{2, 3, 1, 2, 4, 3}, {7}},              // Expected: 2
                {{1, 4, 4}, {4}},                       // Expected: 1
                {{1, 1, 1, 1, 1, 1, 1, 1}, {11}},       // Expected: 0
                {{1, 2, 3, 4, 5}, {15}}                 // Expected: 5
        };

        for (int[][] testCase : testCases) {
            int[] nums = testCase[0];
            int target = testCase[1][0];

            int result = solution.minSubArrayLen(target, nums);
            System.out.println("Input: target = " + target + ", nums = " + Arrays.toString(nums) + ", Output: " + result);
        }
    }


}
