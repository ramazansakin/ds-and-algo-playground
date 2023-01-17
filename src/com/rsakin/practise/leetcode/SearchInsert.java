package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int startInd = 0, endInd = nums.length - 1, lastInd = 0;
        while (startInd <= endInd) {
            int midInd = startInd + (endInd - startInd) / 2;
            if (nums[midInd] == target) {
                return midInd;
            } else if (nums[midInd] < target) {
                lastInd = startInd = midInd + 1;
            } else {
                endInd = midInd - 1;
                lastInd = endInd + 1;
            }
        }
        return lastInd;
    }

    public static void main(String[] args) {

        int[] testArr1 = {3, 5, 7, 8, 9, 10, 12, 13};
        System.out.println("Solution for test case : " + Arrays.toString(testArr1) + " >  index : " + new SearchInsert().searchInsert(testArr1, 6));

    }

}
