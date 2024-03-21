package com.rsakin.practise.coding.string;

public class FindNeedleInHaystack {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
            if (haystack.startsWith(needle, i)) return i;
        return -1;
    }

}
