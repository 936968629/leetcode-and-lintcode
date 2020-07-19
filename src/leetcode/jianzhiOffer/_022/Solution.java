package leetcode.jianzhiOffer._022;

import lintcode.ListNode;

public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode curK = head;
        for (int i = 0; i < k; i++) {
            curK = curK.next;
        }
        if (curK == null) {
            return head;
        }

        ListNode cur = head;
        while (curK != null) {
            cur = cur.next;
            curK = curK.next;
        }
        return cur;
    }

}
