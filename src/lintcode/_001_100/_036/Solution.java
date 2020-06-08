package lintcode._001_100._036;

import lintcode.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        int length = 0;
        ListNode len_cur = head;
        while (len_cur != null) {
            length += 1;
            len_cur = len_cur.next;
        }
        if (m > length || n > length) {
            assert false;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        for (int i = 1; i<m;i++) {
            prev = prev.next;
        }
        ListNode startNode = prev.next;
        ListNode mNode = startNode;
        ListNode prevNode = null;
        for (int i = m ; i< n + 1; i++) {
            ListNode next = mNode.next;
            mNode.next = prevNode;
            prevNode = mNode;
            mNode = next;
        }
        prev.next = prevNode;
        startNode.next = mNode;
        return dummyNode.next;
    }

    public static void main(String[] args) {


    }
}
