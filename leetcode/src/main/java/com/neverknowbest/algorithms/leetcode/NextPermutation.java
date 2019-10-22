package com.neverknowbest.algorithms.leetcode;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            --i;
        }
        reverse(nums, i, nums.length);
        if (i != 0) {
            int j = i;
            int k = nums[i - 1];
            while (nums[j] <= k) {
                ++j;
            }
            nums[i - 1] = nums[j];
            nums[j] = k;
        }
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end - 1; i < j; ++i, --j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
