package com.neverknowbest.algorithms.leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int l = 0, r = height.length - 1, result = 0;
        while (l < r) {
            int lh = height[l], rh = height[r];
            if (lh < rh) {
                while (l < r && height[++l] <= lh) {
                    result += lh - height[l];
                }
            } else {
                while (l < r && height[--r] <= rh) {
                    result += rh - height[r];
                }
            }
        }
        return result;
    }
}
