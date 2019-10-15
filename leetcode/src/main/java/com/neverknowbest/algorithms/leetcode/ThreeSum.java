package com.neverknowbest.algorithms.leetcode;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> appeared = new HashSet<>();
        int n = nums.length;
        int i = 0;
        while (i < n - 1) {
            if (nums[i + 1] == nums[i]) {
                appeared.add(nums[i]);
            }
            int j = i + 1;
            while (j < n) {
                while (j < n - 1 && nums[j + 1] == nums[j]) {
                    ++j;
                }
                int expect = -nums[i] - nums[j];
                if (appeared.contains(expect) && (expect != nums[j] || j - i + 1 >= 3)) {
                    result.add(Arrays.asList(-nums[i] -nums[j], nums[i], nums[j]));
                }
                ++j;
            }
            appeared.add(nums[i]);
            ++i;
            while (i < n - 1 && nums[i] == nums[i - 1]) {
                ++i;
            }
        }
        return result;
    }
}
