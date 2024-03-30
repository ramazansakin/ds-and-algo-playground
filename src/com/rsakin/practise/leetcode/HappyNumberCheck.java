package com.rsakin.practise.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberCheck {


    // Example case:
    // 19
    // 1^2 + 9^2 = 82
    // 8^2 + 2^2 = 100
    // 1^2 + 0^2 + 0^2 = 1, that is; 19 is happy number

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false; // Detected a cycle, the number is not happy
            }
            seen.add(n);

            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }

        return true; // The number is happy
    }


    public static void main(String[] args) {
        int n1 = 19;
        System.out.println(isHappy(n1)); // Output: true

        int n2 = 2;
        System.out.println(isHappy(n2)); // Output: false
    }

}