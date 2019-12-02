package lintcode._904;

import lintcode.ListNode;

public class Solution {

    public ListNode plusOne(ListNode head) {
        // Write your code here
        if (head == null){
            return null;
        }

        ListNode reverse = reverse(head);
        ListNode newCur = reverse;
        int sum = 0;
        int entry = 1;
        while (reverse != null){
            sum = reverse.val + entry;
            if (sum == 10){
                entry = 1;
                sum -= 10;
                reverse.val = 0;
            }else{
                entry = 0;
            }
            reverse.val = sum;
            reverse = reverse.next;
        }

        if (entry == 1){
            ListNode newNode1 = new ListNode(1);
            head.next = newNode1;
        }

        ListNode node = reverse(newCur);

        return node;
    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        sol.plusOne(head);
    }
}
