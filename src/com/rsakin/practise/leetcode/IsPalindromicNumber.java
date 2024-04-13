package com.rsakin.practise.leetcode;

public class IsPalindromicNumber {

    // how to implement
    // 121 -> how to reverse it
    // So while getting modula & division like 121 % 10 = 1 and 121 / 10 = 12
    // then while dividing and getting modula, we can build the reversed number of it

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
        // tricky way to solve :)
        // StringBuilder sb = new StringBuilder(number);
        // String reversedNumber = sb.reverse().toString();
        System.out.println(number + " is palindromic number : " + new IsPalindromicNumber().isPalindrome(number));

        int number2 = 122221;
        System.out.println(number2 + " is palindromic number : " + new IsPalindromicNumber().isPalindrome(number2));

    }

}
