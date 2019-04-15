package lintcode._228;

import lintcode.ListNode;

public class Solution {

    public ListNode middleNode(ListNode head) {
        // write your code here
        ListNode cur = head;
        if (cur == null){
            return null;
        }
        if (cur.next == null){
            return cur;
        }
        ListNode slow = cur;
        ListNode fast = cur;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

}
