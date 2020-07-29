package com.neverknowbest.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSums = new HashMap<>();
        preSums.put(0, 1);
        return dfs(root, 0, sum, preSums);
    }

    private int dfs(TreeNode root, int cur, int sum, Map<Integer, Integer> preSums) {
        if (root == null) {
            return 0;
        }
        cur += root.val;
        int result = preSums.getOrDefault(cur - sum, 0);
        preSums.put(cur, preSums.getOrDefault(cur, 0) + 1);
        result += dfs(root.left, cur, sum, preSums) + dfs(root.right, cur, sum, preSums);
        preSums.put(cur, preSums.get(cur) - 1);
        return result;
    }
}
