package leetcode._001_100._083;

import lintcode.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == prev.val) {
                ListNode next = cur.next;
                prev.next = next;
                cur = next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            if(cur.val == next.val) {
                next = next.next;
                cur.next = null;
            }else {
                cur.next = next;
                cur = next;
                next = next.next;
            }
        }
        return head;
    }

}
