package com.rsakin.practise.leetcode;

import java.util.Arrays;

public class RotateImage {

    // Sample test image
    // 1 2 3
    // 4 5 6
    // 7 8 9

    // 90 Degrees rotate to right / clockwise
    // 7 4 1
    // 8 5 2
    // 9 6 3

    // i -> outer, j -> inner index
    // inner-loop : i: max -> 0, j -> static
    // outer-loop : j: 0 -> max


    // 1 2 3 4
    // 5 6 7 8
    // a b c d
    // e f g h


    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len + 1) / 2; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - j - 1];
                matrix[len - 1 - i][len - j - 1] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage().rotate(matrix);

        System.out.println("After matrix rotation by 90 degrees as clockwise :");
        System.out.println(Arrays.deepToString(matrix));

    }

}
