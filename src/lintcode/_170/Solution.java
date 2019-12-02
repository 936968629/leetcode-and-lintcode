package lintcode._170;

import lintcode.ListNode;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        int length = getLength(head);
        if (length == 0 || length == 1){
            return head;
        }
        k = k % length;
        if (k == 0){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        int count = 0;
        while (count != length - k){
            cur = cur.next;
            count++;
        }
        ListNode newNode = cur.next;
        ListNode resNode = newNode;
        cur.next = null;
        while (newNode.next != null){
            newNode = newNode.next;
        }
        newNode.next = dummy.next;
        return resNode;

    }

    public int getLength(ListNode head){
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}
