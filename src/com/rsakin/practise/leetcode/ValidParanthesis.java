package com.rsakin.practise.leetcode;

import java.util.Stack;

public class ValidParanthesis {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (!stack.isEmpty() &&
                    ((c == ')' && stack.peek() != '(') ||
                            (c == ']' && stack.peek() != '[') ||
                            (c == '}' && stack.peek() != '{'))) {
                return false;
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println("IsValid statement :  -> " + isValid2(""));

        System.out.println("IsValid statement : ()()()))((()()( -> " + isValid("()()()))((()()("));

        System.out.println("IsValid statement : (()()()((()))) -> " + isValid("(()()()((())))"));

    }

    public static boolean isValid2(String s) {
        char[] list = new char[s.length()];
        int h = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    list[h++] = ')';
                    break;
                case '[':
                    list[h++] = ']';
                    break;
                case '{':
                    list[h++] = '}';
                    break;
                default:
                    if (h == 0 || list[--h] != ch) return false;
            }
        }
        return h == 0;
    }

}
