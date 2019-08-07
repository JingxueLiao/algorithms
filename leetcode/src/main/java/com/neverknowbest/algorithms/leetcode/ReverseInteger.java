package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public int reverse(int x) {
        long original = x;
        original = original >= 0 ? original : -original;
        long result = 0;
        while (original != 0) {
            result = result * 10 + original % 10;
            original /= 10;
        }
        result = x >= 0 ? result : -result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int)result;
    }
}
