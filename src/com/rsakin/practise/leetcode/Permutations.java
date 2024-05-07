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

        System.out.println("\n\n-----------------------------------");

        int[] nums2 = {1, 2, 4, 5};
        System.out.println("Solution for " + Arrays.toString(nums2) + " : ");
        new Permutations().permute(nums2).forEach(System.out::print);

        System.out.println("\n\n-----------------------------------");

        int[] nums3 = {1, 1, 4, 5};
        System.out.println("Solution for " + Arrays.toString(nums3) + " : ");
        new Permutations().permute(nums3).forEach(System.out::print);

    }

}
