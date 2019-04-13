package lintcode._102;

import lintcode.ListNode;

import java.util.Stack;

public class Solution {

    public boolean hasCycle(ListNode head) {
        // write your code here
        Stack<Integer> stack = new Stack<>();

        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while( fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

}
