package leetcode._201_300._206;

import lintcode.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode reverseNode = reverseList(next);
        next.next = head;
        head.next = null;
        return reverseNode;
    }

}
