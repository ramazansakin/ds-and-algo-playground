package com.rsakin.practise.coding.string;


import java.util.HashMap;

// ## Sliding Window
// Length of the longest substring without repeating characters using Sliding Window in O(n) time:
public class StringLongestSubstringNoRepeat {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        int n = s.length();
        int maxLength = 0, start = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar)) {
                // If the current character is already in the substring, update the start index
                start = Math.max(charIndexMap.get(currentChar) + 1, start);
            }

            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
            // Update the index of the current character in the map
            charIndexMap.put(currentChar, end);
        }

        return maxLength;
    }

    // Driver code
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("The input string is " + str);

        int len = lengthOfLongestSubstring(str);
        System.out.println("The length of the longest "
                + "non-repeating character "
                + "substring is " + len);
    }

}
