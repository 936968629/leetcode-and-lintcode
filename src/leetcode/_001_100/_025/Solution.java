package leetcode._001_100._025;

import lintcode.ListNode;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        int count = 0;
        ListNode prev = null;
        while (cur != null) {
            if (count == 0) {
                prev = cur;
            }
            if (count == k) {
                ListNode next = cur.next;
                ListNode first = prev.next;
                prev.next = null;
                cur.next = null;
                ListNode reverse = reverse(first);
                prev.next = reverse;
                first.next = next;
                cur = first;
                count = 0;
                prev = cur;
            }
            count++;
            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }



}
