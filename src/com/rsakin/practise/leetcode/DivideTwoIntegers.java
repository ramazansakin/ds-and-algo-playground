package com.rsakin.practise.leetcode;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int tempDividend = Math.abs(dividend), tempDivisor = Math.abs(divisor), res = 0, x;
        while (tempDividend - tempDivisor >= 0) {
            for (x = 0; tempDividend - (tempDivisor << x << 1) >= 0; ++x) ;
            res += 1 << x;
            tempDividend -= tempDivisor << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }

    public static void main(String[] args) {

        System.out.println("Result : " + divide(-2147483648, -1));

    }

}
