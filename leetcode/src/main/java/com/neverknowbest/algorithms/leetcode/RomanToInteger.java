package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); ++i) {
            int cur = 0;
            switch (s.charAt(i)) {
                case 'M' : cur = 1000; break;
                case 'D' : cur = 500; break;
                case 'C' : cur = 100; break;
                case 'L' : cur = 50; break;
                case 'X' : cur = 10; break;
                case 'V' : cur = 5; break;
                case 'I' : cur = 1; break;
            }
            result += cur;
            if (pre < cur) {
                result -= 2 * pre;
            }
            pre = cur;
        }
        return result;
    }
}
