package com.rsakin.practise.leetcode;


// 1.way of solving this problem might be a naive solution which is brute-force checking
// all possible sub arrays but it causes O(n^2) time complexity

// 2.way is more efficient way to solve this problem is sliding window approach
// it provides enhanced traversal of just possible bigger sub arrays in one loop
// so it takes O(n) effectively

public class MaximumSumSubarray {

    public static int[] maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0; // Start index of the current subarray
        int end = 0;   // End index of the current subarray
        int tempStart = 0; // Temporary start index for updating start and end

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i; // Start a new subarray from current index
            } else {
                currentSum += nums[i]; // Extend the current subarray
            }

            // Update the maximum sum and indices if necessary
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{start, end, maxSum};
    }

    public static void main(String[] args) {

        int[] nums = {1, -3, 2, -5, 7, 6, -1, -4, 11, -23};
        int[] result = maxSubArray(nums);
        int start = result[0];
        int end = result[1];
        int maxSum = result[2];
        System.out.println("Maximum Sum Subarray: " + maxSum);
        System.out.println("Start Index: " + start);
        System.out.println("End Index: " + end);

    }

}
