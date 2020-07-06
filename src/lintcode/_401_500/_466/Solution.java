package lintcode._401_500._466;

import lintcode.ListNode;

public class Solution {

    public int countNodes(ListNode head) {
        // write your code here
        int res = 0 ;
        if ( head == null ) {
            return res;
        }

        ListNode cur = head;
        while ( cur != null ) {
            res++;
            cur = cur.next;
        }

        return res;
    }

}
