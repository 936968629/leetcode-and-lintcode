package leetcode.jianzhiOffer._0205;

import lintcode.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int signal = 0;
        while (cur1 != null && cur2 != null) {
            int total = cur1.val + cur2.val + signal;
            if (total >= 10) {
                total = total % 10;
                signal = 1;
            }else {
                signal = 0;
            }
            cur.next = new ListNode(total);
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            int total = cur1.val + signal;
            if (total >= 10) {
                total = total % 10;
                signal = 1;
            }else {
                signal = 0;
            }
            cur.next = new ListNode(total);
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            int total = cur2.val + signal;
            if (total >= 10) {
                total = total % 10;
                signal = 1;
            }else {
                signal = 0;
            }
            cur.next = new ListNode(total);
            cur = cur.next;
            cur2 = cur2.next;
        }
        if (signal == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

}
