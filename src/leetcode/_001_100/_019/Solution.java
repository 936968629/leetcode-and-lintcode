package leetcode._001_100._019;

import lintcode.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        if (length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int i = length - n;
        ListNode cur = dummy;
        for (int j = 0; j < i; j++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

}
