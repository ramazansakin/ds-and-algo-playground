package com.rsakin.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPatternCheck {


//    Example 1:
//    Input: pattern = "abba", s = "dog cat cat dog"
//    Output: true

//    Example 2:
//    Input: pattern = "abba", s = "dog cat cat fish"
//    Output: false

    // 1.way -

    public static boolean wordPattern(String pattern, String s) {

        String[] splits = s.split(" ");
        if (pattern.length() != splits.length) return false;

        Map<Character, String> charWordMapping = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (charWordMapping.containsKey(c)) {
                if (!splits[i].equals(charWordMapping.get(c))) {
                    return false;
                }
            } else {
                if (charWordMapping.containsValue(splits[i])) {
                    return false;
                }
                charWordMapping.put(c, splits[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println(wordPattern(pattern1, s1)); // Output: true

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println(wordPattern(pattern2, s2)); // Output: false

        String pattern3 = "abba";
        String s3 = "dog dog dog dog";
        System.out.println(wordPattern(pattern3, s3)); // Output: false

    }


    // Alternative way with 2 Maps which is easier to understand
    public static boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWordMap = new HashMap<>();
        HashMap<String, Character> wordToCharMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWordMap.containsKey(c)) {
                if (!charToWordMap.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWordMap.put(c, word);
            }

            if (wordToCharMap.containsKey(word)) {
                if (wordToCharMap.get(word) != c) {
                    return false;
                }
            } else {
                wordToCharMap.put(word, c);
            }
        }

        return true;
    }

}
