package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] ss = new char[s.length() * 2 + 1];
        for (int i = 0; i < ss.length; ++i) {
            if (i % 2 == 0) {
                ss[i] = '#';
            } else {
                ss[i] = s.charAt(i / 2);
            }
        }
        int[] lengths = new int[ss.length];
        lengths[0] = 0;
        int farthest = 0, longest = 0;
        for (int i = 1; i < ss.length; ++i) {
            int j = (farthest * 2 - i >= 0 ? Math.min(farthest + lengths[farthest], i + lengths[farthest * 2 - i]) : farthest + lengths[farthest]) + 1;
            while (2 * i - j >= 0 && j < ss.length && ss[2 * i - j] == ss[j]) {
                ++j;
            }
            lengths[i] = j - i - 1;
            if (j - 1 > farthest + lengths[farthest]) {
                farthest = i;
            }
            if (lengths[i] > lengths[longest]) {
                longest = i;
            }
        }
        return s.substring((longest - lengths[longest]) / 2, (longest - lengths[longest]) / 2 + lengths[longest]);
    }
}
