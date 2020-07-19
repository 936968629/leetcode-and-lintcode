package leetcode._001_100._082;

import lintcode.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode left = cur;
            ListNode right = cur;
            while (right != null && right.val == left.val) {
                right = right.next;
            }
            if (left.next == right) {
                prev = cur;
                cur = cur.next;
            }else {
                prev.next = right;
//                prev = right;
                cur = right;
            }
        }
        return dummy.next;
    }

}
