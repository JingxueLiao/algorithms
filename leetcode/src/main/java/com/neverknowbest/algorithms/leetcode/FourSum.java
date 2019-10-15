package com.neverknowbest.algorithms.leetcode;

import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (i < n - 3) {
            int j = i + 1;
            while (j < n - 2) {
                int partial = nums[i] + nums[j];
                int k = j + 1, l = n - 1;
                while (k < l) {
                    int sum = partial + nums[k] + nums[l];
                    if (sum < target) {
                        do {
                            ++k;
                        } while (k < l && nums[k] == nums[k - 1]);
                    } else if (sum > target) {
                        do {
                            --l;
                        } while (k < l && nums[l] == nums[l + 1]);
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        do {
                            ++k;
                        } while (k < l && nums[k] == nums[k - 1]);
                        do {
                            --l;
                        } while (k < l && nums[l] == nums[l + 1]);
                    }
                }
                do {
                    ++j;
                } while (j < n - 2 && nums[j] == nums[j - 1]);
            }
            do {
                ++i;
            } while (i < n - 3 && nums[i] == nums[i - 1]);
        }
        return result;
    }
}
