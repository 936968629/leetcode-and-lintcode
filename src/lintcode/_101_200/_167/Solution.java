package lintcode._101_200._167;

import lintcode.ListNode;

public class Solution {

    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dumyNode = new ListNode(-1);
        ListNode dumyCur = dumyNode;
        int jinwei = 0;
        while ( cur1 != null || cur2 != null) {
            int val1 = 0;int val2 = 0; int val = 0;
            if ( cur1 == null ) {
                val2 = cur2.val;
                cur2 = cur2.next;
            }else if (cur2 == null ) {
                val1 = cur1.val;
                cur1 = cur1.next;
            }else{
                val1 = cur1.val;
                val2 = cur2.val;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            val = val1+val2+jinwei;
            if ( val >= 10 ) {
                val -= 10;
                jinwei = 1;
            }else{
                jinwei = 0;
            }
            ListNode newNode = new ListNode(val);
            dumyCur.next = newNode;
            dumyCur = dumyCur.next;
        }
        if ( jinwei == 1 ) {
            ListNode newNode = new ListNode(1);
            dumyCur.next = newNode;
        }
        return dumyNode.next;
    }

}
