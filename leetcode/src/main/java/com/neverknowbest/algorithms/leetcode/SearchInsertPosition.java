package com.neverknowbest.algorithms.leetcode;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int b = 0, e = nums.length;
        while (b < e) {
            int m = b + (e - b) / 2;
            if (nums[m] < target) {
                b = m + 1;
            } else if (nums[m] > target) {
                e = m;
            } else {
                return m;
            }
        }
        return b;
    }
}
