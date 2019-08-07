package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') {
            ++i;
        }
        int sign = 1;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') {
                sign = -1;
            }
            ++i;
        }
        long result = 0;
        while (i < n) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                if (result * sign <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else if (result * sign >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
            ++i;
        }
        return (int)result * sign;
    }
}
