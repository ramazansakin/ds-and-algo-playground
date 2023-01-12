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

}
