package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();

        System.out.println("Possible Parentheses : " + gp.generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        backtrack(resultList, "", n, n);
        return resultList;
    }

    private void backtrack(List<String> list, String str, int left, int right) {

        if (left < 0 || left > right) return;
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        backtrack(list, str + "(", left - 1, right);
        backtrack(list, str + ")", left, right - 1);
    }

}
