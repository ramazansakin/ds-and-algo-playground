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

    // First we need to transpose the matrix, it will be swap(matrix[i][j], matrix[j][i])
    // Then, flip the matrix horizontally

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
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
