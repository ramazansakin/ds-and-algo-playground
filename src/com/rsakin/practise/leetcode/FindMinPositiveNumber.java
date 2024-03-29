package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class FindMinPositiveNumber {


    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            else if (nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1};
        System.out.println("Positive min number for the array " + Arrays.toString(nums) + " : " +
                new FindMinPositiveNumber().firstMissingPositive(nums));

    }


    // easiest way to solve this, the naive solution is sorting the list
    // then check each index with corresponding number is there
    // like below
    public int firstMissingPositive2(int[] nums) {
        Arrays.sort(nums);
        int missing = 1;

        for (int num : nums) {
            if (num <= 0) continue;
            // If the current element is the same as the missing positive integer, increment missing
            if (num == missing) missing++;
            else if (num > missing) {
                // If the current element is greater than the missing positive integer, return missing
                return missing;
            }
        }
        return missing;
    }

}
