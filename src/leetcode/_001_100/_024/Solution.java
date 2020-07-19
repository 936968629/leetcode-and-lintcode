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

}
