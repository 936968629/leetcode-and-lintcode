package leetcode.jianzhiOffer._0207;

import lintcode.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headB = headB.next;
                headA = headA.next;
            }
        }else {
            int diff = lengthB - lengthA;
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
            while (headA != null && headB != null) {
                if (headA == headB) {
                    return headA;
                }
                headB = headB.next;
                headA = headA.next;
            }
        }

        return null;
    }

    public int getLength(ListNode head) {
        int length = 0 ;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}
