package com.rsakin.practise.leetcode;

import java.util.*;

public class LetterCombinationsPhoneNumber {


    // 2.way with Queue based solution -> LinkedList
    String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;

        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        // Test case with Queue solution
        String numbers = "23";
        System.out.println("Solution for input : " + numbers + " >> " + new LetterCombinationsPhoneNumber().letterCombinations(numbers));

        // Test case with backtracking
        String numbers2 = "23456";
        System.out.println("Solution for input : " + numbers2 + " >> " + new LetterCombinationsPhoneNumber().letterCombinations2(numbers2));

    }


    //    Example 1:
    //    Input: digits = "23"
    //    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    // Here we can use a map to relate numbers with chars set
    // Or, we can also use efficiently String array with corresponding indexes
    // Then while traversing the numbers which were pressed, we need to build possible phone numbers
    // In this case, we can use backtracking,
    public static List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        Map<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        backtrack(result, "", digits, mapping, 0);
        return result;
    }

    private static void backtrack(List<String> result, String combination, String digits, Map<Character, String> mapping, int index) {
        if (index == digits.length()) {
            result.add(combination);
        } else {
            char digit = digits.charAt(index);
            String letters = mapping.get(digit);
            for (char letter : letters.toCharArray()) {
                backtrack(result, combination + letter, digits, mapping, index + 1);
            }
        }
    }

}
