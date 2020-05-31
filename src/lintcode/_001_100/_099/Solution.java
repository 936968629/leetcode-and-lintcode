package lintcode._001_100._099;

import lintcode.ListNode;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public void reorderList(ListNode head) {
        // write your code here

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode reverseMid = reverse(mid);
//        slow.next = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = reverseMid;
            reverseMid = reverseMid.next;
            cur.next.next = next;
            cur = next;
        }

    }

    public ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode cur = head;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        sol.reorderList(head);
        sol.test9();
    }

    public void test9(){
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i <= 1020;i++ ){
            arr.add(i);
        }
        int len = arr.size();
        if(len > 99){
            int i = 0;
            int next =  i + 99;
            while ( next < len ) {
                List<Integer> list = arr.subList(i, next);
                list.forEach(x->{
                    System.out.print(x+",");
                });
                System.out.println();
                i = next;
                next += 99;
            }
            List<Integer> shengyu = arr.subList(i, len);
            shengyu.forEach(x->{
                System.out.print(x+",");
            });
        }

    }

}
