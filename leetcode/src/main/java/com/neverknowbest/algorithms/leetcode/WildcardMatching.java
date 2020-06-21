package com.neverknowbest.algorithms.leetcode;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int n = s.length(), m = p.length();
        boolean[][] match = new boolean[n + 1][m + 1];
        match[0][0] = true;
        for (int i = 0; i < m; ++i) {
            match[0][i + 1] = match[0][i] && p.charAt(i) == '*';
        }
        for (int i = 0; i < n; ++i) {
            match[i + 1][0] = false;
            for (int j = 0; j < m; ++j) {
                if (p.charAt(j) == '*') {
                    match[i + 1][j + 1] = match[i + 1][j] || match[i][j + 1];
                } else {
                    match[i + 1][j + 1] = match[i][j] && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i));
                }
            }
        }
        return match[n][m];
    }
}
