package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int n = s.length(), m = p.length();
        boolean[][] match = new boolean[n + 1][m + 1];
        match[0][0] = true;
        for (int i = 1; i <= m; ++i) {
            if (p.charAt(i - 1) == '*') {
                match[0][i] = match[0][i - 2];
            } else {
                match[0][i] = false;
            }
        }
        for (int i = 1; i <= n; ++i) {
            match[i][0] = false;
            for (int j = 1; j <= m; ++j) {
                char c = p.charAt(j - 1);
                if (c >= 'a' && c <= 'z') {
                    match[i][j] = match[i - 1][j - 1] && c == s.charAt(i - 1);
                } else if (c == '.') {
                    match[i][j] = match[i - 1][j - 1];
                } else if (c == '*') {
                    match[i][j] = match[i][j - 2] || ((p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) && match[i - 1][j]);
                }
            }
        }
        return match[n][m];
    }
}
