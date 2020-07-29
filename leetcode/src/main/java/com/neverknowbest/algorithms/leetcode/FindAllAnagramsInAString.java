package com.neverknowbest.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty() || s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] sc = new int[26], pc = new int[26];
        int n = s.length(), m = p.length();
        for (int i = 0; i < m; ++i) {
            ++sc[s.charAt(i) - 'a'];
            ++pc[p.charAt(i) - 'a'];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n - m; ++i) {
            if (isAnagram(sc, pc)) {
                result.add(i);
            }
            --sc[s.charAt(i) - 'a'];
            if (i < n - m) {
                ++sc[s.charAt(i + m) - 'a'];
            }
        }
        return result;
    }

    private boolean isAnagram(int[] s, int[] p) {
        for (int i = 0; i < s.length; ++i) {
            if (s[i] != p[i]) {
                return false;
            }
        }
        return true;
    }
}
