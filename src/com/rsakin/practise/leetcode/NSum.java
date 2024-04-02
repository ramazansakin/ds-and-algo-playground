package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NSum {

    // For exp, 4Sum can be generated like below easily by kSum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();

        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(Arrays.asList((int) target - nums[i], nums[i]));
                }
            }
            s.add((long) nums[i]);
        }

        return res;
    }

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
