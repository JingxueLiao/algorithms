package com.neverknowbest.algorithms.leetcode;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int time = 0, b = 0, e = 0, longest = 0;
        while (longest < nums.length - 1) {
            time++;
            for (int i = b; i <= e && i < nums.length; ++i) {
                longest = Math.max(longest, i + nums[i]);
            }
            b = e + 1;
            e = longest;
        }
        return time;
    }
}
