package com.rsakin.practise.coding.string;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] testCase1 = {"flower", "flow", "flight"};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + java.util.Arrays.toString(testCase1));
        System.out.println("Output: " + longestCommonPrefix(testCase1));

        // Test Case 2
        String[] testCase2 = {"dog", "race-car", "car"};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: " + java.util.Arrays.toString(testCase2));
        System.out.println("Output: " + longestCommonPrefix(testCase2));
    }

}
