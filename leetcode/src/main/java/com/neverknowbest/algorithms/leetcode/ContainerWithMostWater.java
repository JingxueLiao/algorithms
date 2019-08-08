package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int i = 0, j = height.length - 1;
        int result = 0;
        while (i < j) {
            result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return result;
    }
}
