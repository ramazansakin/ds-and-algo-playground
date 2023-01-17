package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            IntStream.range(0, nums.length).filter(i -> !used[i] && (i <= 0 || nums[i] != nums[i - 1] || used[i - 1])).forEach(i -> {
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            });
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 5};
        System.out.println("Solution for " + Arrays.toString(nums) + " : ");
        new PermutationsII().permuteUnique(nums).forEach(System.out::print);

    }

}
