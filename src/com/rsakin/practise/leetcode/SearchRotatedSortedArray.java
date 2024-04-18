package com.rsakin.practise.leetcode;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Otherwise, right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray main = new SearchRotatedSortedArray();

        // Test cases
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2, 3};
        int target1 = 0;
        System.out.println("Index of " + target1 + " in nums1: " + main.search(nums1, target1)); // Output: 4

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Index of " + target2 + " in nums2: " + main.search(nums2, target2)); // Output: -1

        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Index of " + target3 + " in nums3: " + main.search(nums3, target3)); // Output: -1

        int[] nums4 = {1, 3};
        int target4 = 3;
        System.out.println("Index of " + target4 + " in nums4: " + main.search(nums4, target4)); // Output: 1
    }


}

