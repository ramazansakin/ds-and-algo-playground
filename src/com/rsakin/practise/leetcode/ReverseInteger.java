package com.rsakin.practise.leetcode;

public class ReverseInteger {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int mod = x % 10;
            res = mod + res * 10;
            x /= 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        // Test cases
        int[] testCases = {123, -123, 120, 0, 1534236469};

        // Expected results
        int[] expectedResults = {321, -321, 21, 0, 0};

        // Run tests
        for (int i = 0; i < testCases.length; i++) {
            int result = test.reverse(testCases[i]);
            System.out.println("Input: " + testCases[i] + ", Output: " + result + ", Expected: " + expectedResults[i] + ", Result: " + (result == expectedResults[i] ? "Pass" : "Fail"));
        }

    }

}
