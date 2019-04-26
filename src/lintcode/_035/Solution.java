package lintcode._035;

public class Solution {


    public ListNode reverse(ListNode head) {
        // write your code here

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }



}
