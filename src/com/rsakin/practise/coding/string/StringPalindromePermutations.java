package com.rsakin.practise.coding.string;

import java.util.HashMap;
import java.util.Map;

public class StringPalindromePermutations {

    public static void main(String[] args) {
        printPalindromePermutations("aababaa");
    }

    public static void printPalindromePermutations(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        char[] halfPalindrome = new char[s.length() / 2];
        char oddChar = '\0';

        int index = 0;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (count % 2 != 0) {
                if (oddChar != '\0') {
                    // If there is already an odd frequency character, palindrome is not possible
                    System.out.println("Palindrome not possible");
                    return;
                }
                oddChar = c;
            }

            for (int i = 0; i < count / 2; i++) {
                halfPalindrome[index++] = c;
            }
        }

        generatePermutations(halfPalindrome, oddChar, 0);
    }

    private static void generatePermutations(char[] halfPalindrome, char oddChar, int index) {
        if (index == halfPalindrome.length) {
            printPalindrome(halfPalindrome, oddChar);
            return;
        }

        for (int i = index; i < halfPalindrome.length; i++) {
            swap(halfPalindrome, index, i);
            generatePermutations(halfPalindrome, oddChar, index + 1);
            swap(halfPalindrome, index, i); // Backtrack
        }
    }

    private static void printPalindrome(char[] halfPalindrome, char oddChar) {
        StringBuilder palindrome = new StringBuilder(new String(halfPalindrome));
        palindrome.append(oddChar).append(new StringBuilder(new String(halfPalindrome)).reverse());
        System.out.println(palindrome);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

