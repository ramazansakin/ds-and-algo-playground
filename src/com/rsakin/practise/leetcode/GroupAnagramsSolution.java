package com.rsakin.practise.leetcode;

import java.util.*;

public class GroupAnagramsSolution {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            // sort all the words to group them depending on related char frequencies
            Arrays.sort(chars);

            String k = new String(chars);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // test case - 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        // Output: [["eat","tea","ate"],["tan","nat"],["bat"]] -> order is not important

        // test case - 2
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        // Output: [[""]]

        // test case - 3
        String[] strs3 = {"a", "b", "date", "tade", "car", "arc"};
        System.out.println(groupAnagrams(strs3));
        // Output: [["a"]]
    }

}
