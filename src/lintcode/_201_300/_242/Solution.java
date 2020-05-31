package lintcode._201_300._242;

import lintcode.ListNode;
import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> result = new ArrayList<>();
        if ( root == null ) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ) {
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                ListNode newNode = new ListNode(poll.val);
                cur.next = newNode;
                cur = newNode;
                if ( poll.left != null ) {
                    queue.offer(poll.left);
                }
                if ( poll.right != null ) {
                    queue.offer(poll.right);
                }
            }
            result.add(head.next);
        }
        return result;
    }

}
