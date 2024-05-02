package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println("Possible Parentheses : " + gp.generateParenthesis(3));

        System.out.println("---------------");

        System.out.println("Possible Parentheses with alternative solution : " + gp.generateParenthesis2(4));

    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        backtrack(resultList, "", n, n);
        return resultList;
    }

    private void backtrack(List<String> list, String str, int left, int right) {

        if (left > right) return;

        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > 0)
            backtrack(list, str + "(", left - 1, right);
        if (right > 0)
            backtrack(list, str + ")", left, right - 1);
    }


    // *****
    // Alternative similar solution
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        backtrack2(result, "", 0, 0, n);
        return result;
    }

    private void backtrack2(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack2(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack2(result, current + ")", open, close + 1, max);
        }
    }

}
