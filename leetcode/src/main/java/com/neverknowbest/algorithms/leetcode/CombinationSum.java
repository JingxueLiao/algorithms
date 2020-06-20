package com.neverknowbest.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        return combinationSum(candidates, target, 0);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (start == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>());
            }
            return result;
        }
        int num = candidates[start];
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; num * i <= target; ++i) {
            List<List<Integer>> pre = combinationSum(candidates, target - num * i, start + 1);
            pre.forEach(c -> {
                List<Integer> l = new ArrayList<>();
                l.addAll(cur);
                l.addAll(c);
                result.add(l);
            });
            cur.add(num);
        }
        return result;
    }
}
