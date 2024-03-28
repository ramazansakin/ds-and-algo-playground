package com.rsakin.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {


//    Example 1:
//    Input: nums = [1,2,3,1], k = 3
//    Output: true

//    Example 2:
//    Input: nums = [1,0,1,1], k = 1
//    Output: true

    // 1.way - naive solution which is brute force
    // using 2 for loop and checking all elements by each and then if same numbers occurred
    // then check the indexes, difference is equal or lower than k
    // T: O(n^2) , S: O(1)


    // 2.way - using map to hold number & index together
    // T: O(1) , S: O(n) -> we hold both numbers and corresponding indexes as well -> "2*n" but effectively "n"
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> numberByIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberByIndex.containsKey(nums[i])) {
                Integer elmIndex = numberByIndex.get(nums[i]);
                if (i - elmIndex <= k) return true;
                else numberByIndex.put(nums[i], i); // update the index with last
            } else {
                numberByIndex.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(containsNearbyDuplicate(nums1, k1)); // Output: true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(containsNearbyDuplicate(nums2, k2)); // Output: true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums3, k3)); // Output: false
    }

}
