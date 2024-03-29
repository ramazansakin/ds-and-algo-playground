package com.rsakin.practise.leetcode;

public class FirstOccurrenceOfStringIndex {

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
            if (haystack.startsWith(needle, i)) return i;
        return -1;
    }

    public static void main(String[] args) {

        System.out.println("Result of first Occ : " + strStr("mississippi", "pi"));

        System.out.println("Result of first Occ : " + strStr("mississippi", "po"));

        System.out.println("Result of first Occ : " + strStr("mississippi", "sip"));

    }

}
