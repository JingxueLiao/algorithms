package com.neverknowbest.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs("", n, 0, result);
        return result;
    }

    private void dfs(String cur, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(cur);
            return;
        }
        if (left > 0) {
            dfs(cur + "(", left - 1, right + 1, result);
        }
        if (right > 0) {
            dfs(cur + ")", left, right - 1, result);
        }
        return;
    }
}
