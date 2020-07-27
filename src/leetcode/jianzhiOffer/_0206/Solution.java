package leetcode.jianzhiOffer._0206;

import lintcode.ListNode;

import java.util.List;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode reverse = reverse(next);
        ListNode cur = head;
        while (reverse != null & cur != null ) {
            if (reverse.val != cur.val) {
                return false;
            }
            reverse = reverse.next;
            cur = cur.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
