package com.neverknowbest.algorithms.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        permute(new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList())), new ArrayList<>(), result);
        return result;
    }

    private void permute(Set<Integer> nums, List<Integer> cur, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (Object o : nums.toArray()) {
            Integer i = (Integer) o;
            nums.remove(i);
            cur.add(i);
            permute(nums, cur, result);
            cur.remove(cur.size() - 1);
            nums.add(i);
        }
    }
}
