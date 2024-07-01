package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionElemSortedArray {

    // Binary Search approach to find first and latest number on a sorted array
    // Normal sorted version of the question solution takes just 2 * O(logn)
    // if the array is not sorted we could sort the array first but it ll be not feasible because it ll take O(n.logn) to sort
    // So if the array is not sorted we could try to use map to keep number and indexes and just moving forward on the list until the end,
    // we could find the first and last occurrence of the requested number
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the starting position
        result[0] = findStartingPosition(nums, target);

        // If the starting position is -1, the target is not present
        if (result[0] == -1) {
            return result;
        }

        // Find the ending position
        result[1] = findEndingPosition(nums, target);

        return result;
    }

    private int findStartingPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findEndingPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};

        System.out.println("Solution for 8 : " + Arrays.toString(new FindFirstAndLastPositionElemSortedArray().searchRange(nums, 8)));

        System.out.println();

        System.out.println("Solution for 5 : " + Arrays.toString(new FindFirstAndLastPositionElemSortedArray().searchRange(nums, 5)));

    }

}
