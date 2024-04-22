package com.rsakin.practise.leetcode;

// Input Word : COMEONDADDY
// Row : 3

// Result
// COD
// OENAD
// MDY
// Append all together the above 3 strings like : CODOENADMDY

public class ZigZagString {

    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; ++i)
            sb[i] = new StringBuilder();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; ++idx) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = numRows - 2; idx >= 1 && i < len; --idx) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; ++idx)
            sb[0].append(sb[idx]);

        return sb[0].toString();
    }

    public static void main(String[] args) {
        ZigZagString solution = new ZigZagString();

        // Test case 1
        String s1 = "COMEONDADDY";
        int numRows1 = 3;
        String result1 = solution.convert(s1, numRows1);
        System.out.println("Test Case 1:");
        System.out.println("Input: s = \"" + s1 + "\", numRows = " + numRows1);
        System.out.println("Output: \"" + result1 + "\"");

        // Test case 2
        String s2 = "COMEONDADY";
        int numRows2 = 4;
        String result2 = solution.convert(s2, numRows2);
        System.out.println("\nTest Case 2:");
        System.out.println("Input: s = \"" + s2 + "\", numRows = " + numRows2);
        System.out.println("Output: \"" + result2 + "\"");
    }

}
