package com.rsakin.practise.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int mod = x % 10;
            res = mod + res * 10;
            x /= 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }
}
