package com.rsakin.practise.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        int[] ans = new int[num1.length() + num2.length() - 1];
        // Make the normal multiplication operations
        for (int i = 0; i < num1.length(); ++i) {
            for (int j = 0; j < num2.length(); ++j) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        // Calculate all digits with carry
        for (int i = ans.length - 1; i > 0; --i) {
            if (ans[i] > 9) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {

        String num1 = "6913259244", num2 = "71103343";
        System.out.println("Solution for " + num1 + " * " + num2 + " : " + new MultiplyStrings().multiply(num1, num2));

        // case 2
        String num3 = "123", num4 = "456";
        System.out.println("Solution for " + num3 + " * " + num4 + " : " + new MultiplyStrings().multiply(num3, num4));

    }

    // Alternative easier way to solve
    public String multiply2(String num1, String num2) {
        long no1 = strToInt(num1);
        long no2 = strToInt(num2);
        long sum = no1 * no2;
        return "" + sum;
    }

    private long strToInt(String number) {
        long convertedNum = 0;
        for (int i = 0; i < number.length(); i++) {
            convertedNum = 10 * convertedNum + (number.charAt(i) - '0');
        }
        return convertedNum;
    }

}
