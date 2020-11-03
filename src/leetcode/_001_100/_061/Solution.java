package leetcode._001_100._061;

import lintcode.ListNode;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        if (length <= 1) {
            return head;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode reverse = reverse(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = reverse;
        ListNode cur = dummy;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
            if (count == k) {
                break;
            }
        }
        ListNode newHead = dummy.next;
        ListNode next = cur.next;
        cur.next = null;
        ListNode reverse1 = reverse(dummy.next);
        ListNode reverse2 = reverse(next);
        dummy.next = reverse1;
        newHead.next = reverse2;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
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

    public static void main(String[] args) {
        // 1->2->3->4->5->NULL, k = 2
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.rotateRight(head, 2);
    }

}
