package com.rsakin.practise.leetcode;

import java.util.*;

public class LongestValidParentheses {


    // (()())()(()))
    // we need to add -1 first to prevent NPE/Null Pointer Error on first pop
    // Then check the latest close index with latest open index and get diff

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {

        // Test cases
        String[] testCases = {
                "(()", // Expected: 2
                ")()())", // Expected: 4
                "", // Expected: 0
                "(", // Expected: 0
                ")", // Expected: 0
                "((()))", // Expected: 6
                "()(()", // Expected: 2
                "()()()", // Expected: 6
                "((()()))", // Expected: 8
                "((())))())" // Expected: 6
        };

        // Run tests
        for (String testCase : testCases) {
            int result = longestValidParentheses(testCase);
            System.out.println("Test case: " + testCase + ", Result: " + result);
        }

    }

}
