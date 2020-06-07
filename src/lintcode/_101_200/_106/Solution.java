package lintcode._101_200._106;

import lintcode.ListNode;
import lintcode.TreeNode;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if ( head == null ) {
            return null;
        }
        if ( head.next == null ) {
            return new TreeNode(head.val);
        }

        ListNode slow = findMiddlerPre(head);
        ListNode middleNode = slow.next;
        slow.next = null;

        TreeNode treeNode = new TreeNode(middleNode.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(middleNode.next);
        return treeNode;
    }

    public ListNode findMiddlerPre(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
