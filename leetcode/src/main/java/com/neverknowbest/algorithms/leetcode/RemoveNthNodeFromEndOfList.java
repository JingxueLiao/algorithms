package com.neverknowbest.algorithms.leetcode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head, q = dummy;
        while (n != 0 && p != null) {
            --n;
            p = p.next;
        }
        if (n > 0) {
            return head;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dummy.next;
    }
}
