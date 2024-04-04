package com.rsakin.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteSolution {

    /*
    * Example 1:
        Input: ransomNote = "a", magazine = "b"
        Output: false

        Example 2:
        Input: ransomNote = "aa", magazine = "ab"
        Output: false

        Example 3:
        Input: ransomNote = "aa", magazine = "aab"
        Output: true
    * */
    public static boolean canConstruct(String ransomNote, String magazine) {

        StringBuilder sbMagazine = new StringBuilder(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);

            if (sbMagazine.indexOf("" + c) != -1) {
                sbMagazine.setCharAt(sbMagazine.indexOf("" + c), '.');
            } else return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println(canConstruct(ransomNote1, magazine1)); // Output: false

        String ransomNote2 = "aa";
        String magazine2 = "ab";
        System.out.println(canConstruct(ransomNote2, magazine2)); // Output: false

        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println(canConstruct(ransomNote3, magazine3)); // Output: true

        String ransomNote4 = "fihjjjjei";
        String magazine4 = "hjibagacbhadfaefdjaeaebgi";
        System.out.println(canConstruct(ransomNote4, magazine4)); // Output: false

    }


    // Alternative impl, keep frequencies
    public static boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count occurrences of each character in magazine
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if magazine contains enough occurrences of each character for ransom note
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) <= 0) {
                return false; // Character not found or not enough occurrences
            }
            charCount.put(c, charCount.get(c) - 1); // Decrement count for the character
        }

        return true; // Ransom note can be constructed
    }


    // Alternative 2, we can define an array like int[26] to hold all chars,
    // and we can keep updating this array like index[c-'a'] = i+1 , after finding each time the index
    // to search for the char in magazine again after the last index found whether still there is a next one
    // or no other then false
    public boolean canConstruct3(String ransomNote, String magazine) {
        int[] index = new int[26];
        for(char c: ransomNote.toCharArray()){
            int i = magazine.indexOf(c, index[c-'a']);
            if(i == -1)
                return false;
            index[c-'a'] = i+1;
        }
        return true;
    }


}
