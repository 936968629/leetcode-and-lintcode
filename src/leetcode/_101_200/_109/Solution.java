package leetcode._101_200._109;

import lintcode.ListNode;
import lintcode.TreeNode;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return helper(head);
    }

    public TreeNode helper(ListNode head) {


        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(head.next);
        return root;
    }

    public ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
