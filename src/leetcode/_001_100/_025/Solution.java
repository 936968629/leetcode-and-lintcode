package leetcode._001_100._025;

import lintcode.ListNode;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int i = 0;
        ListNode startNode = null;
        ListNode startNodePrev = null;
        ListNode endNode = null;
        ListNode endNodeNext = null;
        while (cur != null) {
            i++;
            if (i == 1) {
                startNodePrev = prev;
                startNode = cur;
                prev = cur;
                cur = cur.next;
            }else if (i == k) {
                endNode = cur;
                endNodeNext = cur.next;
                endNode.next = null;
                startNodePrev.next = null;
                //翻转
                ListNode reverse = reverse(startNode);
                startNodePrev.next = reverse;
                startNode.next = endNodeNext;
                cur = endNodeNext;
                prev = startNode;
                i = 0;
            }else {
                prev = cur;
                cur = cur.next;
            }

        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
