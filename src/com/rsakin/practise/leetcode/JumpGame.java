package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class JumpGame {

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

        int[] path = {10, 10, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
        System.out.println("Path : " + Arrays.toString(path));
        System.out.println("Min step to end : " + new JumpGame().jump(path));

    }

}
