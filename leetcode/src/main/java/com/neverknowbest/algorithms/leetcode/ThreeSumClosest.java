package com.neverknowbest.algorithms.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (i < n - 2) {
            int expect = target - nums[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (Math.abs(expect - sum) < Math.abs(target - result)) {
                    result = sum + nums[i];
                }
                if (sum < expect) {
                    do {
                        ++j;
                    } while (j < k && nums[j] == nums[j - 1]);
                } else if (sum > expect) {
                    do {
                        --k;
                    } while (j < k && nums[k] == nums[k + 1]);
                } else {
                    return target;
                }
            }
            do {
                ++i;
            } while (i < n - 2 && nums[i] == nums[i - 1]);
        }
        return result;
    }
}
