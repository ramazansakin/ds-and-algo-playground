package com.rsakin.practise.leetcode;

public class MultiplyStrings {

    public static void main(String[] args) {

        String num1 = "6913259244", num2 = "71103343";
        System.out.println("Solution for " + num1 + " * " + num2 + " : " + new MultiplyStrings().multiply(num1, num2));

        // case 2
        String num3 = "123", num4 = "456";
        System.out.println("Solution for " + num3 + " * " + num4 + " : " + new MultiplyStrings().multiply(num3, num4));

    }

    // Alternative easier way to solve
    public String multiply(String num1, String num2) {
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
