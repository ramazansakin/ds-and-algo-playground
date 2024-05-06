package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class MinJumpGame {

    public int jump(int[] nums) {
        int jumpSize = 0, curLast = 0, curLastest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curLastest = Math.max(curLastest, i + nums[i]);
            if (i == curLast  || curLastest >= nums.length - 1) {
                ++jumpSize;
                curLast = curLastest;
                if (curLast >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumpSize;
    }

    public static void main(String[] args) {

        // Test cases
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test Case 1");
        System.out.println("Path : " + Arrays.toString(nums1));
        System.out.println("Min step to end : " + new MinJumpGame().jump(nums1));

        System.out.println("------------------------");

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Test Case 2");
        System.out.println("Path : " + Arrays.toString(nums2));
        System.out.println("Min step to end : " + new MinJumpGame().jump(nums2));

        System.out.println("------------------------");

        int[] nums3 = {3, 2, 1, 0, 4};
        System.out.println("Test Case 3");
        System.out.println("Path : " + Arrays.toString(nums3));
        System.out.println("Min step to end : " + new MinJumpGame().jump(nums3));

        System.out.println("------------------------");

        int[] nums4 = {1};
        System.out.println("Test Case 4");
        System.out.println("Path : " + Arrays.toString(nums4));
        System.out.println("Min step to end : " + new MinJumpGame().jump(nums4));

        System.out.println("------------------------");

        int[] path = {10, 10, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
        System.out.println("Test Case 5");
        System.out.println("Path : " + Arrays.toString(path));
        System.out.println("Min step to end : " + new MinJumpGame().jump(path));

    }

}
