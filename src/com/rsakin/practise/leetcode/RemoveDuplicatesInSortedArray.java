package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            nums[count++] = nums[i];
        }
        // Truncate the array to remove the last remaining elements
        Arrays.fill(nums, count, nums.length, 0);
        return count;
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[count++] = nums[i];
        }
        // Truncate the array to remove the last remaining elements
        Arrays.fill(nums, count - 1, nums.length, 0);
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {-3, -1, 0, 0, 0, 3, 3};

        System.out.println("Result : " + removeElement(nums, 0));
        System.out.println("After remove Elements : " + Arrays.toString(nums));

        System.out.println("--------------------------------------");

        int[] nums2 = {-3, -1, 0, 0, 0, 3, 3};

        removeDuplicates(nums2);
        System.out.println("After remove Dup : " + Arrays.toString(nums2));


    }

}
