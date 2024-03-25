package com.rsakin.practise.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.' &&
                        // define a unique name for each slot and check whether we ll face or not again
                        (!seen.add(number + "-row-" + i) ||
                                !seen.add(number + "-column-" + j) ||
                                !seen.add(number + "-cross-" + i / 3 + "-" + j / 3)))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] sudokuBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("The sample sudoku is valid : " + new IsValidSudoku().isValidSudoku(sudokuBoard));

    }
}
