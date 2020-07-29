package leetcode._001_100._092;

import lintcode.ListNode;
import sun.security.krb5.internal.tools.Klist;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        ListNode mNode = null;
        ListNode mNodePrev = null;
        ListNode nNode = null;
        ListNode next = null;
        for (int i = 1; i <= n; i++) {
            if (m == i) {
                mNodePrev = prev;
                mNode = cur;
                prev.next = null;
            }
            if (n == i) {
                nNode = cur;
                next = cur.next;
                cur.next = null;
            }
            prev = cur;
            cur = cur.next;
        }

        ListNode reverse = reverse(mNode);
        mNodePrev.next = reverse;
        mNode.next = next;
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
