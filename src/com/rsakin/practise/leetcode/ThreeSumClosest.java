package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int firstInd = 0; firstInd < nums.length - 2; firstInd++) {
            int secondInd = firstInd + 1;
            int thirdInd = nums.length - 1;
            while (secondInd < thirdInd) {
                int total = nums[firstInd] + nums[secondInd] + nums[thirdInd];
                int currDiff = Math.abs(target - total);
                if (currDiff == 0)
                    return total;
                if (currDiff < Math.abs(target - closestSum))
                    closestSum = total;
                if (total < target) secondInd++;
                else if (total > target) thirdInd--;
            }
        }
        return closestSum;
    }

}
