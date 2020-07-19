package leetcode.jianzhiOffer._0202;

import lintcode.ListNode;

public class Solution {

    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return head.val;
        }
        ListNode slow = head;
        while (cur != null) {
            slow = slow.next;
            cur = cur.next;
        }
        return slow.val;
    }

}
