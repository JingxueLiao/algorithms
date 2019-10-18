package com.neverknowbest.algorithms.leetcode;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        long x = dividend, y = divisor;
        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;
        long i = y, j = 1;
        while (i << 1 <= x) {
            i <<= 1;
            j <<= 1;
        }
        long result = 0;
        while (x >= y) {
            while (x < i) {
                i >>= 1;
                j >>= 1;
            }
            x -= i;
            result += j;
        }
        result = dividend < 0 ^ divisor < 0 ? -result : result;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
