package com.rsakin.practise.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            // check there is a complement value for target num in map, if so, use it
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 1, 1, 1, 1, 1, 7};

        System.out.println("Solution : " + Arrays.toString(twoSum(arr, 8)));

    }

}
