package leetcode._101_200._143;

import lintcode.ListNode;

public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode middle = findMid(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        right = reverse(right);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cur1 = left;
        ListNode cur2 = right;
        int i = 0;
        while (cur1 != null && cur2 != null) {
            if (i % 2 == 0) {
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
            i++;
        }
        cur.next = cur2 == null ? cur1 : cur2;
        head = dummy.next;
    }


    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
