package com.rsakin.practise.leetcode;

public class IntToRoman {

    // 1.way which is a naive solution with brute-force approach
    // map all the numbers with corresponding chars and then divide input number from 1 to 1000
    // to check whether it includes or not and specify the number with char
    // Regarding the complexities, Time : O(13) 13 is length of the defined numbers, because we just traverse it
    // for all inputs and its effectively O(1), and also for Space: O(1) because, we still use some constant amount of extra space
    public String intToRoman2(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }


    // 2.way, optimized solution
    // we can map all related possible chars with numbers instead of defining some commons
    // now it looks more concise and understandable and efficient, it is also O(1) but little bit better than
    // first approach, for Space: its again O(1) because of the still limited number of mappings but now we have more mappings than before
    // That means now, space complexity is little bit increased but still O(1) effectively
    public String intToRoman(int num) {
        final String M[] = {"", "M", "MM", "MMM"};
        final String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        final String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        final String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder sb = new StringBuilder();
        sb.append(M[num / 1000]).append(C[(num % 1000) / 100]).append(X[(num % 100) / 10]).append(I[num % 10]);
        return sb.toString();
    }


    public static void main(String[] args) {

        int testNumber = 1994;
        System.out.println(testNumber + " as Roman Number : " + new IntToRoman().intToRoman(testNumber));

    }

    // 3rd alternative solution
    // looping the number against defined corresponding chars instead of using mapping list
    public String intToRoman3(int num) {
        StringBuilder sb = new StringBuilder();

        // Thousands place
        sb.append("M".repeat(num / 1000));
        num %= 1000;

        // Hundreds place
        if (num >= 900) {
            sb.append("CM");
            num -= 900;
        } else if (num >= 500) {
            sb.append("D");
            sb.append("C".repeat((num - 500) / 100));
            num %= 100;
        } else if (num >= 400) {
            sb.append("CD");
            num -= 400;
        } else {
            sb.append("C".repeat(num / 100));
            num %= 100;
        }

        // Tens place
        if (num >= 90) {
            sb.append("XC");
            num -= 90;
        } else if (num >= 50) {
            sb.append("L");
            sb.append("X".repeat((num - 50) / 10));
            num %= 10;
        } else if (num >= 40) {
            sb.append("XL");
            num -= 40;
        } else {
            sb.append("X".repeat(num / 10));
            num %= 10;
        }

        // Ones place
        if (num >= 9) {
            sb.append("IX");
            num -= 9;
        } else if (num >= 5) {
            sb.append("V");
            sb.append("I".repeat(num - 5));
        } else if (num == 4) {
            sb.append("IV");
        } else {
            sb.append("I".repeat(num));
        }

        return sb.toString();
    }


}
