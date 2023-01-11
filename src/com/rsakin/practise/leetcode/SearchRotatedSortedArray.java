package com.rsakin.practise.leetcode;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num;
            if ((nums[mid] < nums[0]) == (target < nums[0]))
                num = nums[mid];
            else
                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (num < target) lo = mid + 1;
            else if (num > target) hi = mid - 1;
            else return mid;
        }
        return -1;
    }
}

