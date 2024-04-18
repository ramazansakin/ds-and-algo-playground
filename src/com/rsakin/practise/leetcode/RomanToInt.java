package com.rsakin.practise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        result += romanToInt.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (romanToInt.get(s.charAt(i)) > romanToInt.get(s.charAt(i + 1)))
                result += romanToInt.get(s.charAt(i));
            else
                result -= romanToInt.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("Roman to Int for XIV : " + new RomanToInt().romanToInt("XIV")); // 14

        System.out.println("Roman to Int for MCMXCIV : " + new RomanToInt().romanToInt("MCMXCIV")); // 1994

    }
}
