package lintcode._101_200._173;

import lintcode.ListNode;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if ( head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);

        ListNode cur = head;

        while ( cur != null ) {
            ListNode next = cur.next;
            ListNode newCur = dummy;
            while ( newCur.next != null && newCur.next.val <= cur.val ) {
                newCur = newCur.next;
            }
            cur.next = newCur.next;
            newCur.next = cur;

            cur = next;
        }

        return dummy.next;
    }
}
