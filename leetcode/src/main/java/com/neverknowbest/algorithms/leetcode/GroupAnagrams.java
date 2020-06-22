package com.neverknowbest.algorithms.leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> anagrams = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String s = new String(cs);
            anagrams.putIfAbsent(s, new ArrayList<>());
            anagrams.get(s).add(strs[i]);
        }
        return new ArrayList<>(anagrams.values());
    }
}
