package lintcode._101_200._166;

import lintcode.ListNode;

public class Solution {

    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        int length = getLength(head);
        if ( length < n ) {
            return null;
        }
        int signal = length - n + 1;
        int i = 1;
        ListNode cur = head;
        while ( i < signal ) {
            cur = cur.next;
            i++;
        }
        return cur;
    }

    public int getLength(ListNode head) {
        int length = 0;
        if ( head == null ) {
            return length;
        }
        ListNode cur = head;
        while ( cur != null ) {
            length ++;
            cur = cur.next;
        }
        return length;
    }
}
