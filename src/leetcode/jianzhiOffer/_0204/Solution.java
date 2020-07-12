package leetcode.jianzhiOffer._0204;

import lintcode.ListNode;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode cur = head;
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        while (cur != null) {
            if (cur.val < x) {
                l1Cur.next = cur;
                l1Cur = l1Cur.next;
            }else {
                l2Cur.next = cur;
                l2Cur = l2Cur.next;
            }
            cur = cur.next;
        }
        l2Cur.next = null;
        l1Cur.next = l2.next;
        return l1.next;
    }

}
