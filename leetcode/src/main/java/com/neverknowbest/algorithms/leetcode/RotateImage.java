package com.neverknowbest.algorithms.leetcode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; ++i) {
            for (int j = i; j < (n + 1) / 2; ++j) {
                for (int k = 0, r = i, c = j, v = matrix[r][c]; k < 4; ++k) {
                    int nr = c, nc = n - 1 - r;
                    int tmp = matrix[nr][nc];
                    matrix[nr][nc] = v;
                    v = tmp;
                    r = nr;
                    c = nc;
                }
            }
        }
    }
}
