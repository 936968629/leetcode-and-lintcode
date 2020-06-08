package lintcode._301_400._380;

import lintcode.ListNode;

public class Solution {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        int length_A = getLength(headA);
        int length_B = getLength(headB);
        ListNode curA = headA;
        ListNode curB = headB;
        if (length_A == 0 || length_B == 0){
            return null;
        }
        if (length_A > length_B){
            int bet = length_A - length_B;
            for (int i=0;i<bet;i++){
                curA = curA.next;
            }
            while (curA != null){
                if (curA.equals(curB)){
                    return curA;
                }else{
                    curA = curA.next;
                    curB = curB.next;
                }
            }
        } else{
            int bet = length_B - length_A;
            for (int i=0;i<bet;i++){
                curB = curB.next;
            }
            while (curB != null){
                if (curB.equals(curA)){
                    return curB;
                }else{
                    curA = curA.next;
                    curB = curB.next;
                }
            }
        }

        return null;
    }

    public int getLength(ListNode head){
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            cur = cur.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {

    }
}
