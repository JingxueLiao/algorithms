package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || numRows <= 0) {
            return null;
        }
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            int j = i;
            while (j < n) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    if (j + 2 * (numRows - 1 - i) < n) {
                        sb.append(s.charAt(j + 2 * (numRows - 1 -i)));
                    }
                }
                j += 2 * numRows - 2;
            }
        }
        return sb.toString();
    }
}
