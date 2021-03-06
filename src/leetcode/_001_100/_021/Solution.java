package leetcode._001_100._021;

import lintcode.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode l1cur = l1;
        ListNode l2cur = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1cur != null && l2cur != null) {
            if (l1cur.val < l2cur.val) {
                cur.next = l1cur;
                l1cur = l1cur.next;
            }else {
                cur.next = l2cur;
                l2cur = l2cur.next;
            }
            cur = cur.next;
        }
        if(l1cur != null) {
            cur.next = l1cur;
        }
        if(l2cur != null) {
            cur.next = l2cur;
        }
        return dummy.next;
    }

}
