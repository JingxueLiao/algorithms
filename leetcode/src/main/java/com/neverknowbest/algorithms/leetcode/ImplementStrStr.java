package com.neverknowbest.algorithms.leetcode;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int[] next = generateNext(needle);
        int n = haystack.length(), m = needle.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
            if (j == -1) {
                ++i;
                j = 0;
            }
        }
        return j == m ? i - m : -1;
    }

    private int[] generateNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 1; i < n; ++i) {
            int j = next[i - 1];
            while (j != -1 && s.charAt(j) != s.charAt(i - 1)) {
                j = next[j];
            }
            next[i] = j + 1;
        }
        for (int i = 1; i < n; ++i) {
            if (s.charAt(next[i]) == s.charAt(i)) {
                next[i] = next[next[i]];
            }
        }
        return next;
    }
}
