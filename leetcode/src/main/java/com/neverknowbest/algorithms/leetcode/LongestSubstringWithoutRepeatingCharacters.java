package com.neverknowbest.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> charIndex = new HashMap<>();
        int n = s.length(), longest = 0, start = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (start <= charIndex.getOrDefault(c, -1)) {
                longest = Math.max(longest, i - start);
                start = charIndex.get(c) + 1;
            }
            charIndex.put(c, i);
        }
        longest = Math.max(longest, s.length() - start);
        return longest;
    }
}
