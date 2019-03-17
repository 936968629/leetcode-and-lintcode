package com.leetcode._002;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummpy = new ListNode(-1);
        ListNode cur = dummpy;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int temp = flag;
            if (l1!=null){
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }

            if (temp > 9){
                flag = 1;
                temp = temp - 10;
            }else{
                flag = 0;
            }

            cur.next = new ListNode(temp);
            cur = cur.next;
        }

        if (flag == 1) {
            cur.next = new ListNode(1);
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        sol.addTwoNumbers(l1, l2);
    }

}
