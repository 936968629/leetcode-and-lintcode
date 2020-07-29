package leetcode._001_100._061;

import lintcode.ListNode;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getLength(head);
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode reverse = reverse(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = reverse;
        ListNode prev = dummy;
        ListNode cur = dummy;
        ListNode next = null;
        int i = 0;
        while (i < k) {
            prev = cur;
            cur = cur.next;
            next = cur.next;
            i++;
        }
        cur.next = null;
        ListNode l1Head = dummy.next;
        ListNode reverse1 = reverse(next);
        ListNode reverse2 = reverse(dummy.next);
        dummy.next = reverse2;
        l1Head.next = reverse1;
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
