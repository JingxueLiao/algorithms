package com.neverknowbest.algorithms.leetcode;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = -1, end = -1;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            return 0;
        }
        for (int i = nums.length - 1; i > start; --i) {
            if (nums[i] < nums[i - 1]) {
                end = i;
                break;
            }
        }
        int min = nums[start], max = nums[start];
        for (int i = start; i <= end; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < start; ++i) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > end; --i) {
            if (nums[i] < max) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }
}
