package com.neverknowbest.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = Arrays.asList("");
        for (int i = 0; i < digits.length(); ++i) {
            int d = digits.charAt(i) - '0';
            if (!mapping[d].isEmpty()) {
                List<String> cur = new ArrayList<>();
                result.forEach(s -> {
                    String chars = mapping[d];
                    for (int j = 0; j < chars.length(); ++j) {
                        cur.add(s + chars.charAt(j));
                    }
                });
                result = cur;
            }
        }
        return result;
    }
}
