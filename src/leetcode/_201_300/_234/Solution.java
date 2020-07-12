package leetcode._201_300._234;

import lintcode.ListNode;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMiddle(head);
        ListNode reverse = reverse(mid.next);
        mid.next = null;
        ListNode cur = head;
        while (cur != null && reverse!=null) {
            if (cur.val != reverse.val) {
                return false;
            }
            cur = cur.next;
            reverse = reverse.next;
        }
        return true;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode slow = dumy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev= null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
