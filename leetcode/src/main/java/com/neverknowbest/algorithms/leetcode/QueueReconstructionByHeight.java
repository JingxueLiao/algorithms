package com.neverknowbest.algorithms.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < people.length; ++i) {
            result.add(people[i][1], people[i]);
        }
        int[][] resultQueue = new int[people.length][];
        for (int i = 0; i < resultQueue.length; ++i) {
            resultQueue[i] = result.get(i);
        }
        return resultQueue;
    }
}
