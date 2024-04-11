package com.rsakin.practise.leetcode;

public class Atoi {

    public int myAtoi(String s) {
        // base case
        if (s == null) return 0;
        // remove leading and trailing whitespace characters
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, start = 0, len = s.length();
        // use long to prevent int overflow+/underflow-
        long sum = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            ++start;
        } else if (s.charAt(0) == '+') {
            ++start;
        }

        for (int i = start; i < len; i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) break;

            sum = sum * 10 + (c - '0');
        }

        // Check for overflow+/underflow- edge-cases
        if (sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        // Return 0 if no digits were found
        if (start == 0 && !Character.isDigit(s.charAt(0))) return 0;

        return (int) sum * sign;
    }


    public static void main(String[] args) {
        Atoi solution = new Atoi();

        // Test cases
        String[] testCases = {
                "42",               // Expected: 42
                "   -42",           // Expected: -42
                "4193 with words",  // Expected: 4193
                "words and 987",    // Expected: 0
                "-91283472332",     // Expected: -2147483648
                "3.14159",          // Expected: 3
                "21474836460",      // Expected: 2147483647
                "-21474836460"      // Expected: -2147483648
        };

        for (String testCase : testCases) {
            int result = solution.myAtoi(testCase);
            System.out.println("Input: \"" + testCase + "\", Output: " + result);
        }
    }


}
