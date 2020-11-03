package leetcode._001_100._092;

import lintcode.ListNode;
import sun.security.krb5.internal.tools.Klist;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 1;
        ListNode cur = head;
        ListNode prev = dummy;

        ListNode start = null;
        ListNode end = null;
        while (cur != null) {
            if (count == m) {
                start = prev;
            }
            if(count == n) {
                end = cur;
            }
            prev = cur;
            cur = cur.next;
            count++;
        }
        ListNode next = end.next;
        end.next = null;
        ListNode startNode = start.next;
        ListNode reverse = reverse(start.next);
        start.next = reverse;
        startNode.next = next;
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
