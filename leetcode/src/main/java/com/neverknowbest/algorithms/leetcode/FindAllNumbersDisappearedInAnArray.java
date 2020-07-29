package com.neverknowbest.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < nums.length; ++i) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; ++i) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }
}
