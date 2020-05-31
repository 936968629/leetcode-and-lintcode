package lintcode._101_200._113;

import lintcode.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if ( head == null || head.next == null ) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode cur = dummy;

        while ( cur.next != null && cur.next.next != null) {
            if ( cur.next.val == cur.next.next.val ) {
                int val = cur.next.val;
                while ( cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        1->2->3->3->4->4->5->null
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        solution.deleteDuplicates(listNode);
    }
}
