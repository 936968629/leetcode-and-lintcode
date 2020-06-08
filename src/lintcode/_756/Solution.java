package lintcode._756;

import lintcode.ListNode;

public class Solution {


    public long multiplyLists(ListNode l1, ListNode l2) {
        // write your code here
        if ( l1 == null || l2 == null ) {
            return 0;
        }
        long i = transferToInt(l1);
        long j = transferToInt(l2);

        return i * j;
    }

    public long transferToInt(ListNode l1) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = l1;
        while ( cur != null ) {
            sb.append(cur.val);
            cur = cur.next;
        }
        return Long.valueOf(sb.toString());
    }

}
