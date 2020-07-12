package leetcode.jianzhiOffer._0203;

import lintcode.ListNode;

public class Solution {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val= next.val;
        node.next = next.next;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
