package lintcode._401_500._451;

import lintcode.ListNode;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        // write your code here
        if ( head == null ) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;

        while ( cur.next != null && cur.next.next != null ) {
            ListNode nextNode = cur.next;
            ListNode next2Node = cur.next.next;
            ListNode next3Node = cur.next.next.next;
            cur.next = next2Node;
            next2Node.next = nextNode;
            nextNode.next = next3Node;
            cur = cur.next.next;
        }

        return dummyNode.next;
    }

}
