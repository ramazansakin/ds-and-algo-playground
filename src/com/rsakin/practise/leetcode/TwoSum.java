package com.rsakin.practise.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // numbers = [2,7,11,15], target = 9
    // response :  [1,2]
    // 1.way is the naive solution which is brute force approach
    // we can try all the number couples within 2 for loops
    // Then, Time: O(n^2) & Space: O(1)

    // 2.way - better efficiency, but it contains extra space and this solution for "UNORDERED LIST"
    // This contains extra space like O(n) also this can be used if given list is un-ordered
    // But given list is ordered, we can use "Two Pointer Approach" to find the target
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


    // 3.way - better efficient and it DOES NOT contain extra space and this solution for "ORDERED LIST"
    // Or we need to sort the list first, but it ll take O(n.log(n)) time complexity first, we need to take care that as well
    // Arrays.sort(numbers);
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-indexed array
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // No solution found
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 1, 1, 1, 1, 1, 7};

        System.out.println("Solution : " + Arrays.toString(twoSum(arr, 8)));

    }

}
