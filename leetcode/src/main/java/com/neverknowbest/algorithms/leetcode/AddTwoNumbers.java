package com.neverknowbest.algorithms.leetcode;

/*
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            val += carry;
            carry = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
        }
        return preHead.next;
    }
}
