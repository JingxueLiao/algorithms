package com.neverknowbest.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0, new ArrayList<>());
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target, int start, List<Integer> cur) {
        List<List<Integer>> result = new ArrayList<>();
        if (target < 0 || start == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(cur));
            }
            return result;
        }
        int count = 0, num = candidates[start];
        for (int i = start; i < candidates.length && candidates[i] == num; ++i) {
            ++count;
            cur.add(num);
        }
        for (int i = count; i > 0; --i) {
            result.addAll(combinationSum2(candidates, target - i * num, start + count, cur));
            cur.remove(cur.size() - 1);
        }
        result.addAll(combinationSum2(candidates, target, start + count, cur));
        return result;
    }
}
