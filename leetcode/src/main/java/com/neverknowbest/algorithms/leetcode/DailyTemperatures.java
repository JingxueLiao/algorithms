package com.neverknowbest.algorithms.leetcode;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        Stack<Integer> maxTemps = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; --i) {
            while (!maxTemps.empty() && temperatures[i] >= temperatures[maxTemps.peek()]) {
                maxTemps.pop();
            }
            if (maxTemps.empty()) {
                result[i] = 0;
            } else {
                result[i] = maxTemps.peek() - i;
            }
            maxTemps.push(i);
        }
        return result;
    }
}
