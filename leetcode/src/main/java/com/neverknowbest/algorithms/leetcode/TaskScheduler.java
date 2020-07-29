package com.neverknowbest.algorithms.leetcode;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        if (n <= 0) {
            return tasks.length;
        }
        int[] count = new int[26];
        int sum = 0;
        for (int i = 0; i < 26; ++i) {
            count[i] = 0;
        }
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            sum++;
        }
        for (int i = 0; i < 26; ++i) {
            if (count[i] > max) {
                max = count[i];
                maxCount = 1;
            } else if (count[i] == max) {
                maxCount++;
            }
        }
        return sum + Math.max((max - 1) * (n - maxCount + 1) - (sum - max * maxCount), 0);
    }
}
