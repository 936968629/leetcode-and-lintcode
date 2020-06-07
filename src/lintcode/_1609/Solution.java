package lintcode._1609;

import lintcode.ListNode;

public class Solution {

    public ListNode middleNode(ListNode head) {
        // write your code here.
        if ( head == null ) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
