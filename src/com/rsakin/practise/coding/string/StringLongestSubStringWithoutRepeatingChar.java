package com.rsakin.practise.coding.string;

import java.util.HashMap;
import java.util.Map;

public class StringLongestSubStringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (charIndexMap.containsKey(ch)) {
                start = Math.max(start, charIndexMap.get(ch) + 1);
            }
            charIndexMap.put(ch, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

}
