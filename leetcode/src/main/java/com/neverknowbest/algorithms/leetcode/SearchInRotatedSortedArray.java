package com.neverknowbest.algorithms.leetcode;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < target) {
                if (nums[mid] >= nums[begin] || nums[end] >= target) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > target) {
                if (nums[mid] <= nums[end] || nums[begin] <= target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }
}
