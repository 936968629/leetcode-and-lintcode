package leetcode.jianzhiOffer._0208;

import lintcode.ListNode;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }

}
