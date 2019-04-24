package lintcode._099;

import lintcode.ListNode;

public class Solution {

    public void reorderList(ListNode head) {
        // write your code here

        if (head == null || head.next == null || head.next.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

    }

}
