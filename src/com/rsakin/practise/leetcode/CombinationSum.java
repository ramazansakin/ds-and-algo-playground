package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);    // to prevent duplicates and more efficiency
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target > 0) {
            // target >= candidates[i] is for preventing unnecessary check loops to enhance performance
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {

                // this line for preventing duplicate numbers
                if (i > 0 && candidates[i] == candidates[i - 1]) continue;

                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i + 1);  // i + 1 for not using same index
                cur.remove(cur.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<>(cur));   // prevent later changes, deep copy current list
        }
    }

    public static void main(String[] args) {

        int[] arr = {7, 3, 2, 2, 2, 2, 5, 1, 13};
        int target = 18;
        System.out.println("CombinationSum Solution target " + target + " for array " + Arrays.toString(arr) + " : " + new CombinationSum().combinationSum(arr, target));

        System.out.println("----------------------------");

        // Test CombinationSum3
        int[] arr2 = {7, 3, 2, 1, 1, 5};
        int target2 = 12;
        System.out.println("CombinationSum Solution target " + target2 + " for array " + Arrays.toString(arr2) + " : " + new CombinationSum().combinationSum3(arr2, target2));

    }


    // ################
    // If the question ll be like, not using the same number again
    // Let's say we can have same number in the list or also for above solution,
    // it uses the same number multiple times, to prevent those
    // we can implement like below
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort candidates to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return; // If remaining sum is negative, stop recursion
        else if (remain == 0)
            result.add(new ArrayList<>(tempList)); // If remaining sum is 0, add current combination to result
        else {
            for (int i = start; i < candidates.length; i++) {
                // Skip duplicates to avoid reusing the same element
                if (i > start && candidates[i] == candidates[i - 1]) continue;

                tempList.add(candidates[i]); // Add candidate to current combination
                backtrack(result, tempList, candidates, remain - candidates[i], i); // Continue to find combination recursively
                tempList.remove(tempList.size() - 1); // Backtrack by removing last added candidate
            }
        }
    }

}
