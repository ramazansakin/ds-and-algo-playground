package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class JumpGame {

    public int jump(int[] nums) {
        int jumpSize = 0, curLast = 0, curLastest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curLastest = Math.max(curLastest, i + nums[i]);
            if (i == curLast) {
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

        int[] paths = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
        System.out.println("Solution for " + Arrays.toString(paths) + " : ");
        System.out.println("Min step to end : " + new JumpGame().jump(paths));

    }

}
