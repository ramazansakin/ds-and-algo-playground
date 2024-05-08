package com.rsakin.practise.leetcode;

import java.util.ArrayList;
import java.util.List;

// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.
public class PossibleCombinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    public void combine(List<List<Integer>> res, List<Integer> curr, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
        } else if (k > 0) {
            for (int i = start; i < n; i++) {
                curr.add(i);
                combine(res, curr, i + 1, n, k - 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Case-1)  n:5 , k:3 ");
        List<List<Integer>> combinations1 = new PossibleCombinations().combine(5, 3);
        System.out.println(combinations1);

        System.out.println("------------------------");

        System.out.println("Case-2)  n:7 , k:4 ");
        List<List<Integer>> combinations2 = new PossibleCombinations().combine(7, 4);
        System.out.println(combinations2);

    }

}
