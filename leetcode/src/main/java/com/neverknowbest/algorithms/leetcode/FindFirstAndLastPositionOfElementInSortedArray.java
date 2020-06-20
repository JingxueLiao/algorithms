package com.neverknowbest.algorithms.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int begin = 0, end = nums.length;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        if (end == nums.length || nums[end] != target) {
            return new int[] {-1, -1};
        }
        int[] result = new int[2];
        result[0] = begin = end;
        end = nums.length;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] <= target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        result[1] = begin - 1;
        return result;
    }
}
