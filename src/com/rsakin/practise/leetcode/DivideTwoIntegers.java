package com.rsakin.practise.leetcode;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1; // edge-case

        int tempDividend = Math.abs(dividend), tempDivisor = Math.abs(divisor), res = 0, x;
        while (tempDividend - tempDivisor >= 0) {
            for (x = 0; tempDividend - (tempDivisor << x << 1) >= 0; ++x) ;
            res += 1 << x;
            tempDividend -= tempDivisor << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }

    public static void main(String[] args) {

        System.out.println("Result : " + divide(-23234, 56));
        System.out.println("Result2 : " + divide2(-23234, 56));
        System.out.println();

        System.out.println("Result : " + divide(52344234, 343));
        System.out.println("Result2 : " + divide2(52344234, 343));
        System.out.println();

        // edge-case check
        System.out.println("Result : " + divide(-2147483648, -1));
        System.out.println("Result2 : " + divide2(-2147483648, -1));

    }


    // Without using shifting
    public static int divide2(int dividend, int divisor) {
        // I can use long for checking the integer overflow/underflow
        if (dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE - 1; // edge-case

        int tempDividend = Math.abs(dividend);
        int tempDivisor = Math.abs(divisor);

        int quotient = 0;
        while (tempDividend >= tempDivisor) {
            tempDividend -= tempDivisor;
            quotient++;
        }

        return (dividend > 0) == (divisor > 0) ? quotient : -quotient;  // check & set the sign
    }

}
