package com.rsakin.practise.codility;

import java.util.HashSet;
import java.util.Set;

public class MinNextPositiveNumber {

    public int solution(int[] A) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        int[] arr = {-1, -2, -3};
        System.out.println(" Solution : " + new MinNextPositiveNumber().solution(arr));
    }

}
