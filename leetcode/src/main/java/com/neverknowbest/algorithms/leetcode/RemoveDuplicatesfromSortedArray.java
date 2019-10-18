package com.neverknowbest.algorithms.leetcode;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            ++j;
        }
        return ++i;
    }
}
