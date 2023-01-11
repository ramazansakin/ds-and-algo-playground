package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionElemSortedArray {

    public int[] searchRange(int[] A, int target) {
        // find the target if there is defined in array, if not so, return -1, -1
        int start = firstGreaterOrEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        // find the last occurrence of the target via comparing next greater element
        return new int[]{start, firstGreaterOrEqual(A, target + 1) - 1};
    }

    private int firstGreaterOrEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = (high / 2) + (low / 2); // prevent overflow
            if (A[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8};

        System.out.println("Solution : " + Arrays.toString(new FindFirstAndLastPositionElemSortedArray().searchRange(nums, 8)));

    }

}
