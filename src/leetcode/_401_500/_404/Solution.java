package leetcode._401_500._404;

import lintcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    if (poll.left.left == null && poll.left.right == null) {
                        res += poll.left.val;
                    }
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return res;
    }

}
