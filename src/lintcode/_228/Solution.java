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
        ListNode fast = cur.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

}
