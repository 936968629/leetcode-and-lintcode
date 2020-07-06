package leetcode._001_100._002;

import lintcode.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode prevl1 = reverse(l1);
        ListNode prevl2 = reverse(l2);
        ListNode curl1 = prevl1;
        ListNode curl2 = prevl2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int sign = 0;
        while (curl1 != null && curl2 != null) {
            int val = curl1.val + curl2.val + sign;
            if ( val >= 10 ) {
                val = val % 10;
                sign = 1;
            } else {
                sign = 0;
            }
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = cur.next;
            curl1 = curl1.next;
            curl2 = curl2.next;
        }

        while (curl1 != null) {
            int val = curl1.val + sign;
            if ( val >= 10 ) {
                val = val % 10;
                sign = 1;
            } else {
                sign = 0;
            }
            ListNode newNode = new ListNode(val);
            curl1 = curl1.next;
            cur.next = newNode;
            cur = cur.next;
        }
        while (curl2 != null) {
            int val = curl2.val + sign;
            if ( val >= 10 ) {
                val = val % 10;
                sign = 1;
            } else {
                sign = 0;
            }
            ListNode newNode = new ListNode(val);
            curl2 = curl2.next;
            cur.next = newNode;
            cur = cur.next;
        }
        if ( sign == 1 ) {
            cur.next = new ListNode(1);
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while ( cur != null ) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
