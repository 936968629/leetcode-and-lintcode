package lintcode._099;

import lintcode.ListNode;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import lintcode.TreeNode;
>>>>>>> 90043515c2c99e1e7490b18c478cac5f3f9a7240
=======
import lintcode.TreeNode;
>>>>>>> 90043515c2c99e1e7490b18c478cac5f3f9a7240

public class Solution {

    public void reorderList(ListNode head) {
        // write your code here
<<<<<<< HEAD
<<<<<<< HEAD

        if (head == null || head.next == null || head.next.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

    }

=======
=======
>>>>>>> 90043515c2c99e1e7490b18c478cac5f3f9a7240
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
        sol.reorderList(head);
    }
<<<<<<< HEAD
>>>>>>> 90043515c2c99e1e7490b18c478cac5f3f9a7240
=======
>>>>>>> 90043515c2c99e1e7490b18c478cac5f3f9a7240
}
