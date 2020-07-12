package leetcode._101_200._109;

import lintcode.ListNode;
import lintcode.TreeNode;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = dummyHead;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow.next;
        TreeNode treeNode = new TreeNode(midNode.val);
        slow.next = null;
        treeNode.left = sortedListToBST(dummyHead.next);
        treeNode.right = sortedListToBST(midNode.next);
        return treeNode;
    }


}
