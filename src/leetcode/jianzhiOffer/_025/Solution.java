package leetcode.jianzhiOffer._025;

import lintcode.ListNode;

import java.util.List;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
            cur.next = null;
        }

        if (cur1 != null) {
            cur.next = cur1;
        }

        if (cur2 != null) {
            cur.next = cur2;
        }

        return dummy.next;
    }

}
