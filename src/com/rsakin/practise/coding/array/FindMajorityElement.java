package com.rsakin.practise.coding.array;

import java.util.HashMap;
import java.util.Map;

public class FindMajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            if (count > n / 2) {
                return num; // Found the majority element
            }
            countMap.put(num, count);
        }

        // No majority element found (this line should not be reached as per the problem statement)
        return -1;
    }

}
