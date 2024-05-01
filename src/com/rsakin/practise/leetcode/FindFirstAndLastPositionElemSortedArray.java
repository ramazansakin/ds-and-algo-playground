package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionElemSortedArray {

    // Binary Search approach to find first and latest number on a sorted array
    // Normal sorted version of the question solution takes just 2 * O(logn) even logn + log(n/2) :)
    // if the array is not sorted we could sort the array first but it ll be not feasible because it ll take O(n.logn) to sort
    // So if the array is not sorted we could try to use map to keep number and indexes and just moving forward on the list until the end,
    // we could find the first and last occurrence of the requested number
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the starting position
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
            result[0] = left;
        } else {
            return result; // Target not found
        }

        // Find the ending position
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result[1] = right;

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};

        System.out.println("Solution for 8 : " + Arrays.toString(new FindFirstAndLastPositionElemSortedArray().searchRange(nums, 8)));

        System.out.println();

        System.out.println("Solution for 5 : " + Arrays.toString(new FindFirstAndLastPositionElemSortedArray().searchRange(nums, 5)));

    }

}
