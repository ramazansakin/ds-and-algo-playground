package com.rsakin.practise.leetcode;

public class CountAndSay {

    public String countAndSay(int n) {
        String res = "1";
        while (n-- > 1) {
            StringBuilder tempRes = new StringBuilder();
            for (int i = 0; i < res.length(); i++) {
                int eqNumCounter = 1;
                char numChar = res.charAt(i);
                while (i + 1 < res.length() && numChar == res.charAt(i + 1)) {
                    ++i;
                    ++eqNumCounter;
                }
                tempRes.append(eqNumCounter).append(numChar);
            }
            res = tempRes.toString();
        }
        return res;
    }

    public static void main(String[] args) {

        int num = 4;
        System.out.println("Solution for " + num + " : " + new CountAndSay().countAndSay(num));


        num = 5;
        System.out.println("Solution for " + num + " : " + new CountAndSay().countAndSay(num));

    }
}
