package leetcode._001_100._024;

import lintcode.ListNode;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode nextN = next.next;
            prev.next = next;
            next.next = cur;
            cur.next = nextN;
            prev = cur;
            cur = nextN;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
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
            if (count == 2) {
                ListNode next = cur.next;
                ListNode cur2 = cur;
                ListNode last = prev.next;
                prev.next = cur2;
                cur2.next = last;
                last.next = next;
                cur = last;
                count = 0;
                prev = cur;
            }
            count++;
            cur = cur.next;
        }
        return dummy.next;
    }

}
