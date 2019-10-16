package com.neverknowbest.algorithms.leetcode;

import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode p = pq.poll();
            cur.next = p;
            cur = cur.next;
            if (p.next != null) {
                pq.offer(p.next);
            }
        }
        return dummy.next;
    }
}
