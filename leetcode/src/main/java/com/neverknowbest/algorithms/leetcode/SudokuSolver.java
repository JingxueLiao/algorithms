package com.neverknowbest.algorithms.leetcode;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int r, int c) {
        int i = r, j = c;
        while (i < 9) {
            if (j == 9) {
                ++i;
                j = 0;
                continue;
            }
            if (board[i][j] != '.') {
                ++j;
                continue;
            }
            for (int k = 1; k <= 9; ++k) {
                board[i][j] = (char)('0' + k);
                if (isValid(board, i, j) && solve(board, i, j + 1)) {
                    return true;
                }
            }
            board[i][j] = '.';
            return false;
        }
        return true;
    }

    private boolean isValid(char[][] board, int r, int c) {
        for (int i = 0; i < 9; ++i) {
            if (i != r && board[i][c] == board[r][c]) {
                return false;
            }
            if (i != c && board[r][i] == board[r][c]) {
                return false;
            }
        }
        for (int i = 0; i < 9; ++i) {
            int j = r / 3 * 3 + i / 3, k = c / 3 * 3 + i % 3;
            if (j != r && k != c && board[j][k] == board[r][c]) {
                return false;
            }
        }
        return true;
    }
}
