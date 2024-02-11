package com.rsakin.practise.coding.string;

public class StringLongestPalindromicSubString {

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = s.length(); i > 0; --i) {
            int odd = isPalindromic(s, i, i);
            int even = isPalindromic(s, i, i + 1);
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int isPalindromic(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {

        System.out.println("Solution : " + StringLongestPalindromicSubString.longestPalindrome("babad"));

    }

}
