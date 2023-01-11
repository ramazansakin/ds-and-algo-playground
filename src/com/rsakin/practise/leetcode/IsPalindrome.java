package com.rsakin.practise.leetcode;

public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int res = 0, tempX = x;
        while (tempX != 0) {
            int mod = tempX % 10;
            res = mod + res * 10;
            tempX /= 10;
        }
        return res == x;
    }

    public static void main(String[] args) {

        int number = 1212;
        System.out.println(number + " is palindromic number : " + new IsPalindrome().isPalindrome(number));

    }

}
