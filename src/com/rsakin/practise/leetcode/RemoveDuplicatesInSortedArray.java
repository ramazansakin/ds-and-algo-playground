package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;
            nums[count++] = nums[i];
        }
        return count;
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[count++] = nums[i];
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {-3, -1, 0, 0, 0, 3, 3};

        //System.out.println("After remove Dup : " + removeDuplicates(nums));

        System.out.println("After remove Elements : " + Arrays.toString(nums) + " - result : " + removeElement(nums, 0));

    }

}
