package com.neverknowbest.algorithms.leetcode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode first = p.next, second = p.next.next;
            first.next = second.next;
            second.next = first;
            p.next = second;
            p = first;
        }
        return dummy.next;
    }
}
