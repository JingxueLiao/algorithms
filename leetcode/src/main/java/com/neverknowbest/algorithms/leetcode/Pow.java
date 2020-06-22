package com.neverknowbest.algorithms.leetcode;

public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            if (n >= 0) {
                return 0;
            } else {
                return Double.MAX_VALUE;
            }
        }
        long m = n;
        m = m < 0 ? -m : m;
        double result = 1;
        while (m != 0) {
            if ((m & 1) == 1) {
                result *= x;
            }
            x *= x;
            m >>= 1;
        }
        result = n < 0 ? 1 / result : result;
        return result;
    }
}
