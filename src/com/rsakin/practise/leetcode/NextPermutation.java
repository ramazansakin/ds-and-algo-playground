package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int digitInd = nums.length - 2;
        while (digitInd >= 0 && nums[digitInd + 1] <= nums[digitInd]) {
            digitInd--;
        }
        if (digitInd >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[digitInd]) {
                j--;
            }
            swap(nums, digitInd, j);
        }
        reverse(nums, digitInd + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) swap(nums, start++, end--);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 2, 1, 1, 3};
        System.out.println("Next Permutation : ");
        new NextPermutation().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

    }
}
