package com.rsakin.practise.leetcode;

import java.util.HashMap;

public class IsomorphicString {


    // we can use a map to hold each a <-> b mappings
    // Or we can use 2 map to hold each a -> and b -> a mappings
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) return true;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                }
                map.put(a, b);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("Is Isomorphic egg == add : " + new IsomorphicString().isIsomorphic("egg", "add"));

        System.out.println("Is Isomorphic foo == bar : " + new IsomorphicString().isIsomorphic("foo", "bar"));

        // title  --  paper
        System.out.println("Is Isomorphic title == paper : " + new IsomorphicString().isIsomorphic("title", "paper"));

    }

}
