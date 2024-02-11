package com.rsakin.practise.coding.string;

public class StringLongestPalindromicSubStringDynamicProgramming {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0; // Start index of the longest palindrome
        int maxLength = 1; // Length of the longest palindrome

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check substrings of length 3 and above
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index of the substring

                // Check if the current substring is a palindrome
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;

                    // Update the start index and max length if a longer palindrome is found
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }

        // Extract the longest palindrome substring
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "babad";
        String result = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);
    }

}
