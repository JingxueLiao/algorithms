package com.neverknowbest.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int total = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        for (int i = 0, cur = 0; i < nums.length; ++i) {
            cur += nums[i];
            total += count.getOrDefault(cur - k, 0);
            count.put(cur, count.getOrDefault(cur, 0) + 1);
        }
        return total;
    }
}
