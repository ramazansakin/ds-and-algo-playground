package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }

    public static void main(String[] args) {

        int[] testArr1 = {3, 5, 7, 8, 9, 10, 12, 13};
        System.out.println("Solution for test case : " + Arrays.toString(testArr1) + " >  index : " + new SearchInsert().searchInsert(testArr1, 6));

    }

}
