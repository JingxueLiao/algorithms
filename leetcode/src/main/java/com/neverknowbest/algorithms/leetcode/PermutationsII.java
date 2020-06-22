package com.neverknowbest.algorithms.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), result);
        return result;
    }

    private void permuteUnique(List<Integer> nums, List<Integer> cur, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.size(); ++i) {
            int num = nums.get(i);
            if (used.contains(num)) {
                continue;
            }
            used.add(num);
            cur.add(num);
            nums.remove(i);
            permuteUnique(nums, cur, result);
            nums.add(i, num);
            cur.remove(cur.size() - 1);
        }
    }
}
