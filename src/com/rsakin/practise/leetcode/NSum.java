package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NSum {

    public static void main(String[] args) {

        int[] nums = {2, 3, 5, 6, 8};
        int target = 8;
        int k = 2;
        List<List<Integer>> result = kSum(nums, target, k);
        for (List<Integer> sublist : result) {
            System.out.println(sublist);
        }

    }

    // Alternative solution with backtracking
    public static List<List<Integer>> kSum(int[] nums, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, target, k, 0, current, result);
        return result;
    }

    private static void backtrack(int[] nums, int target, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (k == 0 || start == nums.length || target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, target - nums[i], k - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}
