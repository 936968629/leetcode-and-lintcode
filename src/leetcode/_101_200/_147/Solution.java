package leetcode._101_200._147;

import lintcode.ListNode;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null) {
            if (prev.val <= cur.val) {
                prev = cur;
                cur = cur.next;
            }else {
                ListNode newCur = dummy;
                while (cur.val > newCur.next.val) {
                    newCur = newCur.next;
                }
                ListNode next = cur.next;
                prev.next = next;
                ListNode curNext = newCur.next;
                newCur.next = cur;
                cur.next = curNext;
                cur = next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        solution.insertionSortList(head);
    }

}
