package lintcode._401_500._452;

import lintcode.ListNode;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        if ( head == null ) {
            return head;
        }
        ListNode dummyNode = new ListNode(val-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while ( cur.next != null ) {
            if ( cur.next.val == val ) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Solution solution = new Solution();
        ListNode listNode = solution.removeElements(head, 1);
    }

}
