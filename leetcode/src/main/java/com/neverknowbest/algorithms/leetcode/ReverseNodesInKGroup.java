package com.neverknowbest.algorithms.leetcode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            int i = k;
            ListNode start = cur.next, end = cur;
            while (i != 0 && end != null) {
                --i;
                end = end.next;
            }
            if (i != 0 || end == null) {
                break;
            }
            cur.next = end;
            cur = start;
            ListNode pre = end.next;
            while (start != end) {
                ListNode next = start.next;
                start.next = pre;
                pre = start;
                start = next;
            }
            end.next = pre;
        }
        return dummy.next;
    }
}
