package com.neverknowbest.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<List<Integer>> p = new ArrayList<>();
        p.add(Arrays.asList(1));
        for (int i = 1; i < s.length(); ++i) {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            if (s.charAt(i) == s.charAt(i - 1)) {
                l.add(2);
            }
            for (int j : p.get(i - 1)) {
                if (i - 1 - j >= 0 && s.charAt(i - 1 - j) == s.charAt(i)) {
                    l.add(j + 2);
                }
            }
            p.add(l);
        }
        return p.stream().map(List::size).reduce(0, Integer::sum);
    }
}
