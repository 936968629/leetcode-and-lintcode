package leetcode._001_100._086;

import lintcode.ListNode;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur;
                cur1.next = null;
            }else {
                cur2.next = cur;
                cur2 = cur;
                cur2.next = null;
            }
            cur = next;
        }
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
