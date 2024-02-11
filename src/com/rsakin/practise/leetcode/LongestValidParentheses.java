package com.rsakin.practise.leetcode;

import java.util.*;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
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

        System.out.println("Max Valid Parenthesis : " + new LongestValidParentheses().longestValidParentheses("(()"));
    }

}
