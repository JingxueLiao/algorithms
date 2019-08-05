package com.neverknowbest.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (numIndex.containsKey(target - nums[i])) {
                result[0] = numIndex.get(target - nums[i]);
                result[1] = i;
                break;
            }
            numIndex.put(nums[i], i);
        }
        return result;
    }
}
