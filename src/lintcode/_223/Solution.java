package lintcode._223;

import lintcode.ListNode;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        // write your code here
        if (head == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        ListNode p1 = head;
        ListNode p2 = slow.next;
        while (p1 != null && p2 != null){
            if (p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
