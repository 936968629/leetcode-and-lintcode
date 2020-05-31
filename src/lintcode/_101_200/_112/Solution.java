package lintcode._101_200._112;

import lintcode.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if ( head == null|| head.next == null ) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        while ( next != null ) {
            if ( cur.val == next.val ) {
                next = next.next;
                cur.next = next;
            } else {
                cur = cur.next;
                next = next.next;
            }
        }
        return head;
    }
}
