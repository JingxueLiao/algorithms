package com.neverknowbest.algorithms.leetcode;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        String result = "";
        for (int i = num2.length() - 1; i >= 0; --i) {
            result = add(result, multiply(num1, num2.charAt(i) - '0', num2.length() - 1 - i));
        }
        return result;
    }

    private String multiply(String num1, int num2, int index) {
        if (num2 == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, co = 0;
        while (i >= 0 || co != 0) {
            int v = (i >= 0 ? num1.charAt(i--) - '0' : 0) * num2 + co;
            result.append(v % 10);
            co = v / 10;
        }
        result.reverse();
        for (i = 0; i < index; ++i) {
            result.append(0);
        }
        return result.toString();
    }

    private String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, co = 0;
        while (i >= 0 || j >= 0 || co != 0) {
            int sum = (i >= 0 ? num1.charAt(i--) - '0' : 0) + (j >= 0 ? num2.charAt(j--) - '0' : 0) + co;
            result.append(sum % 10);
            co = sum / 10;
        }
        return result.reverse().toString();
    }
}
