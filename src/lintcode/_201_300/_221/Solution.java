package lintcode._201_300._221;

import lintcode.ListNode;

public class Solution {

    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        ListNode new1 = reverse(l1);
        ListNode new2 = reverse(l2);

        ListNode cur1 = new1;
        ListNode cur2 = new2;
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
        return reverse(dumyNode.next);

    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while ( cur != null ) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
