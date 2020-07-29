package leetcode._1290;

import lintcode.ListNode;

public class Solution {

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode reverse = reverse(head);
        ListNode cur = reverse;
        int i = 0;
        double total = 0;
        while (cur != null) {
            if (cur.val == 1) {
                total += Math.pow(2,i);
            }
            i++;
            cur = cur.next;
        }
        return (int)total;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode reverse = reverse(next);
        next.next = head;
        head.next = null;
        return reverse;
    }

}
