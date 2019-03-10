package com.leetcode._445;

import java.util.Stack;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dumpy = new ListNode(-1);
        ListNode cur = dumpy;
        int flag = 0;
        while ( !stack1.empty() || !stack2.empty()){
            int temp = flag;
            if (!stack1.empty()){
                temp += stack1.pop();
            }
            if (!stack2.empty()){
                temp += stack2.pop();
            }
            if (temp > 9){
                temp = temp - 10;
                flag = 1;
            }else{
                flag = 0;
            }
            ListNode new_node = new ListNode(temp);
            cur.next = new_node;
            cur = new_node;
        }
        if (flag == 1) {
            cur.next = new ListNode(1);
        }

        return reverse(dumpy.next);
    }

    private ListNode reverse(ListNode head){

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
