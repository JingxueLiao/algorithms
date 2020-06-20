package com.neverknowbest.algorithms.leetcode;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return false;
        }
        for (int i = 0; i < 9; ++i) {
            if (board[i] == null || board[i].length != 9) {
                return false;
            }
            if (!isValidRow(board, i) || !isValidCol(board, i) || !isValidBox(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        boolean[] nums = new boolean[10];
        for (int i = 0; i < 9; ++i) {
            char c = board[row][i];
            if (c >= '0' && c <= '9') {
                int j = c - '0';
                if (nums[j]) {
                    return false;
                }
                nums[j] = true;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        boolean[] nums = new boolean[10];
        for (int i = 0; i < 9; ++i) {
            char c = board[i][col];
            if (c >= '0' && c <= '9') {
                int j = c - '0';
                if (nums[j]) {
                    return false;
                }
                nums[j] = true;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int box) {
        boolean[] nums = new boolean[10];
        for (int i = 0; i < 9; ++i) {
            char c = board[box / 3 * 3 + i / 3][box % 3 * 3 + i % 3];
            if (c >= '0' && c <= '9') {
                int j = c - '0';
                if (nums[j]) {
                    return false;
                }
                nums[j] = true;
            }
        }
        return true;
    }
}
