package lintcode._001_100._098;

import lintcode.ListNode;

import java.util.List;

public class Solution {

    public ListNode sortList(ListNode head) {
        if ( head == null || head.next == null ) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        return merge(left,right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while ( left != null && right != null ) {
            if ( left.val < right.val ) {
                cur.next = new ListNode(left.val);
                left = left.next;
            } else {
                cur.next = new ListNode(right.val);
                right = right.next;
            }
            cur = cur.next;
        }
        if ( left != null ) {
            cur.next = left;
        }
        if ( right != null ) {
            cur.next = right;
        }
        return dummy.next;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
