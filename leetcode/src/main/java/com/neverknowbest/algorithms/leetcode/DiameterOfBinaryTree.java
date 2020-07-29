package com.neverknowbest.algorithms.leetcode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root)[0] - 1;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] result = new int[2];
        result[0] = Math.max(left[1] + right[1] + 1, Math.max(left[0], right[0]));
        result[1] = Math.max(left[1], right[1]) + 1;
        return result;
    }
}
