package com.neverknowbest.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int s) {
        return dfs(nums, 0, s, new HashMap<>());
    }

    private int dfs(int[] nums, int cur, int s, Map<Integer, Map<Integer, Integer>> results) {
        if (cur == nums.length) {
            return s == 0 ? 1 : 0;
        }
        if (results.containsKey(cur) && results.get(cur).containsKey(s)) {
            return results.get(cur).get(s);
        }
        int result = 0;
        result += dfs(nums, cur + 1, s - nums[cur], results);
        result += dfs(nums, cur + 1, s + nums[cur], results);
        results.putIfAbsent(cur, new HashMap<>());
        results.get(cur).put(s, result);
        results.get(cur).put(-s, result);
        return result;
    }
}
