package com.neverknowbest.algorithms.leetcode;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int longest = 0;
        int[] lengths = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                lengths[i] = (i >= 2 ? lengths[i - 2] : 0) + 2;
            } else if (s.charAt(i - 1) == ')' && i - 1 - lengths[i - 1] >= 0 && s.charAt(i - 1 - lengths[i - 1]) == '(') {
                lengths[i] = lengths[i - 1] + 2;
                lengths[i] += i - lengths[i] >= 0 ? lengths[i - lengths[i]] : 0;
            }
            longest = Math.max(longest, lengths[i]);
        }
        return longest;
    }
}
