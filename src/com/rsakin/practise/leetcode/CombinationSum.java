package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<>(cur));   // prevent later changes, deep copy current list
        }
    }

    public static void main(String[] args) {

        int[] arr = {7, 3, 2};
        int target = 18;
        System.out.println("CombinationSum Solution target " + target + " for array " + Arrays.toString(arr) + " : " + new CombinationSum().combinationSum(arr, target));

        System.out.println("----------------------------");

        // Test CombinationSum3
        int[] arr2 = {7, 3, 2, 1, 1, 5};
        int target2 = 12;
        System.out.println("CombinationSum Solution target " + target2 + " for array " + Arrays.toString(arr2) + " : " + new CombinationSum().combinationSum3(arr2, target2));

    }

    public static void find(int id, int can[], int target, List<Integer> ds, List<List<Integer>> ans) {
        //   base case
        if (id == can.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // include
        if (target >= can[id]) {
            ds.add(can[id]);
            find(id, can, target - can[id], ds, ans);
            ds.remove(ds.size() - 1);
        }
        find(id + 1, can, target, ds, ans);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        find(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }



    // ################
    // If the question ll be like, not using the same number again
    // Let's say we can have same number in the list or also for above solution,
    // it uses the same number multiple times, to prevent those
    // we can implement like below
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort candidates to handle duplicates
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], result, temp, i + 1); // Move to the next index
                temp.remove(temp.size() - 1);
            }
        }
    }

}
