package com.rsakin.practise.coding.string;

public class StringLongestPalindromicSubString {


    // "Expand Around Center" approach
    int start = 0, maxLen = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            isPalindromic(s, i, i);         // for odd-length possible palindrome
            isPalindromic(s, i, i + 1);     // for even-length possible palindrome
        }
        return s.substring(start, start + maxLen);
    }

    public void isPalindromic(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (maxLen < right - left - 1) {
            start = left + 1;
            maxLen = right - left - 1;
        }

    }


    public static void main(String[] args) {

        System.out.println("Solution : " + new StringLongestPalindromicSubString().longestPalindrome("babad"));

    }

}
