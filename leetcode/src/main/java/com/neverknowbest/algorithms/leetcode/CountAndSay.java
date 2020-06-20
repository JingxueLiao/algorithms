package com.neverknowbest.algorithms.leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = prev.charAt(0);
        for (int i = 1; i < prev.length(); ++i) {
            if (prev.charAt(i) == c) {
                ++count;
            } else {
                sb.append("" + count + c);
                count = 1;
                c = prev.charAt(i);
            }
        }
        sb.append("" + count + c);
        return sb.toString();
    }
}
