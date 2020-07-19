package leetcode._201_300._203;

import lintcode.ListNode;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val == val) {
                prev.next = next;
                cur = next;
            }else {
                prev = cur;
                cur = next;
            }
        }
        return dummy.next;
    }

}
