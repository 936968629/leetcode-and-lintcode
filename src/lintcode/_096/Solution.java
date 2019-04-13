package lintcode._096;

import lintcode.ListNode;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null){
            return null;
        }
        ListNode cur = head;
        ListNode list1 = new ListNode(-1);
        ListNode list1Cur = list1;
        ListNode list2 = new ListNode(-1);
        ListNode list2Cur = list2;
        while (cur != null){
            if (cur.val < x) {
                list1Cur.next = cur;
                list1Cur = list1Cur.next;
                cur = cur.next;
                list1Cur.next = null;
            } else{
                list2Cur.next = cur;
                list2Cur = list2Cur.next;
                cur = cur.next;
                list2Cur.next = null;
            }

        }
        list1Cur.next = list2.next;
        return list1.next;
    }

}
