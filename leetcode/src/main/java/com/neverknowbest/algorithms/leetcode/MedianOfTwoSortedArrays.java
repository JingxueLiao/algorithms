package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    public double medianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            throw new IllegalArgumentException("Both arrays are null");
        }
        int n = nums1 == null ? 0 : nums1.length, m = nums2 == null ? 0 : nums2.length;
        if (n > m) {
            return medianOfTwoSortedArrays(nums2, nums1);
        }
        int i = 0, j = n;
        while (i <= j) {
            int k = i + (j - i) / 2;
            int l = n + (m - n) / 2 - k;
            if (k > 0 && l < m && nums1[k - 1] > nums2[l]) {
                j = k - 1;
            } else if (l > 0 && k < n && nums2[l - 1] > nums1[k]) {
                i = k + 1;
            } else {
                if ((n + m) % 2 == 1) {
                    if (k == n) {
                        return nums2[l];
                    } else if (l == m) {
                        return nums1[k];
                    } else {
                        return Math.min(nums1[k], nums2[l]);
                    }
                } else {
                    int a = 0, b = 0;
                    if (k == 0) {
                        a = nums2[l - 1];
                    } else if (l == 0) {
                        a = nums1[k - 1];
                    } else {
                        a = Math.max(nums1[k - 1], nums2[l - 1]);
                    }
                    if (k == n) {
                        b = nums2[l];
                    } else if (l == m) {
                        b = nums1[k];
                    } else {
                        b = Math.min(nums1[k], nums2[l]);
                    }
                    return (a + b) / 2.0;
                }
            }
        }
        return 0;
    }
}
