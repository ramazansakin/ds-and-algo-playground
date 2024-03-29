package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        result.add(t);
                        k++;
                        l--;

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();

        // Test Case 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        List<List<Integer>> result1 = solution.fourSum(nums1, target1);
        System.out.println("Test Case 1:");
        printResult(result1);

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int target2 = 20;
        List<List<Integer>> result2 = solution.fourSum(nums2, target2);
        System.out.println("\nTest Case 2:");
        printResult(result2);

        // Test Case 3
        int[] nums3 = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target3 = 3;
        List<List<Integer>> result3 = solution.fourSum(nums3, target3);
        System.out.println("\nTest Case 3:");
        printResult(result3);
    }

    // Helper method to print the result
    private static void printResult(List<List<Integer>> result) {
        if (result.isEmpty()) {
            System.out.println("No possible list");
            return;
        }
        for (List<Integer> quadruplet : result) {
            System.out.println(quadruplet);
        }
    }

}
