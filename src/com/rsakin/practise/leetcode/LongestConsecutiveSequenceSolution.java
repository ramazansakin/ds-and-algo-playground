package com.rsakin.practise.leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequenceSolution {


//    Example 1:
//    Input: nums = [100,4,200,1,3,2]
//    Output: 4
//    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

//    Example 2:
//    Input: nums = [0,3,7,2,5,8,4,6,0,1]
//    Output: 9

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                    // If you add the below line, it ll cause java.util.ConcurrentModificationException
                    // So you can not edit the array while tracing it!!!
                    // If you want to do that then you need to use any Concurrent HashSet implementation like
                    // numSet.remove(num);

                    // Alternative
                    // Or we can use a HashMap like number with Boolean which is for visited status
                    // Then after we visit any consecutive number, we dont need to traverse them again

                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        System.gc();
        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequenceSolution solution = new LongestConsecutiveSequenceSolution();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Input: nums = [100,4,200,1,3,2]");
        System.out.println("Output: " + solution.longestConsecutive(nums1)); // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("\nInput: nums = [0,3,7,2,5,8,4,6,0,1]");
        System.out.println("Output: " + solution.longestConsecutive(nums2)); // Output: 9

        int[] nums3 = {1, 2, 0, 1};
        System.out.println("\nInput: nums = [1,2,0,1]");
        System.out.println("Output: " + solution.longestConsecutive(nums3)); // Output: 3

        int[] nums4 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println("\nInput: nums = [9,1,4,7,3,-1,0,5,8,-1,6]");
        System.out.println("Output: " + solution.longestConsecutive(nums4)); // Output: 7
    }

}
