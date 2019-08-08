package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    private static String thousand[] = { "", "M", "MM", "MMM" };
    private static String hundred[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    private static String ten[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    private static String one[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }
        return thousand[num / 1000] + hundred[num / 100 % 10] + ten[num / 10 % 10] + one[num % 10];
    }
}
