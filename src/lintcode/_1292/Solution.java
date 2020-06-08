package lintcode._1292;

import lintcode.ListNode;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        // write your code here
        if ( head == null || head.next == null ) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = head.next;

        ListNode cur = head.next.next;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int i = 1;
        while ( cur != null ) {
            if ( i % 2 == 0 ) {
                cur1.next = cur;
                cur1 = cur1.next;
                cur = cur.next;
                cur1.next = null;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
                cur = cur.next;
                cur2.next = null;
            }
            i++;
        }
        cur1.next = head2;
        cur2.next = null;
        return head1;
    }
}
