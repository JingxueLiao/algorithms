package com.neverknowbest.algorithms.leetcode;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0 || words[0].length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            wordCount.put(words[i], wordCount.getOrDefault(words[i], 0) + 1);
        }
        int n = s.length(), m = words[0].length(), l = m * words.length;
        for (int i = 0; i < m; ++i) {
            Map<String, Queue<Integer>> wordPos = new HashMap<>();
            for (int j = 0; j < words.length; ++j) {
                wordPos.put(words[j], new ArrayDeque<>());
            }
            int start = i;
            for (int j = i; j <= n - m; j += m) {
                String cur = s.substring(j, j + m);
                if (!wordCount.containsKey(cur)) {
                    start = j + m;
                    continue;
                } else {
                    Queue<Integer> posQ = wordPos.get(cur);
                    posQ.add(j);
                    while (!posQ.isEmpty() && posQ.peek() < start) {
                        posQ.remove();
                    }
                    if (wordPos.get(cur).size() > wordCount.get(cur)) {
                        start = wordPos.get(cur).remove() + m;
                    }
                    if (j + m - start == l) {
                        result.add(start);
                    }
                }
            }
        }
        return result;
    }
}
