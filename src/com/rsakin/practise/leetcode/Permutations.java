package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    // Recursive approach with backtracking
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue; // element already exists, skip
                tempList.add(num);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println("Solution for " + Arrays.toString(nums) + " : ");
        new Permutations().permute(nums).forEach(System.out::print);

    }


    // Another recursive approach
    // this is little bit more complex than first backtracking solution
    public List<List<Integer>> permute2(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return permute(list);
    }

    public List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 1) {
            result.add(nums);
            return result;
        }

        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.remove(i);
            List<List<Integer>> permutations = permute(new ArrayList(nums));

            for (List<Integer> perm : permutations) {
                perm.add(0, num);
                result.add(perm);
            }
            nums.add(i, num);
        }

        return result;
    }

}
