package leetcode.jianzhiOffer._052;

import lintcode.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA == 0 || lengthB == 0) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            for (int i = 0; i < diff; i++) {
                curA = curA.next;
            }
        } else {
            int diff = lengthB - lengthA;
            for (int i = 0; i < diff; i++) {
                curB = curB.next;
            }
        }
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}
