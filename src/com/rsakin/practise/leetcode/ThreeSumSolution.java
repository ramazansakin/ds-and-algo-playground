package com.rsakin.practise.leetcode;

import java.util.*;

public class ThreeSumSolution {

    // 1.way - naive solution which is brute-force approach
    // Take 3 nested for loops and check all possible triplets which their sum is 0.
    // Time: O(n^3) , Space: O(1) - no need extra space apart from some temporary variables.


    // 2.way - better efficient
    // First, we need to sort the list -> O(n.log(n))
    // Then, we can loop each index and choose 2nd and 3rd index by "Two Pointer" approach (List is SORTED!)
    // So, it ll be one outer for loop and one inner while loop
    // Time: O(n^2) , Space: O(1)


    // 3.way - better efficient with extra space
    // No need sorting, just we can use "Map" structure to hold each complements
    // Like, TwoSum problem, we ll also loop for the first variable
    // 2nd and 3rd variables ll be chosen on "Complementary Map"
    // It provides better efficiency because NO NEED to sort the list
    // Time: O(n^2) , Space: O(n) - Map usage (2*n)
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            int left = first + 1;
            int right = nums.length - 1;
            // two pointer approach
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum == 0)
                    res.add(Arrays.asList(nums[first], nums[left++], nums[right--]));
                else if (sum < 0) left++;
                else right--;
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {

        int[] arr = {-2, -2, 4, 1, 1, 1, 1, 1, 7};

        System.out.println("Solution for " + Arrays.toString(arr) + " == " + threeSum(arr));

    }

}
