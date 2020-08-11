package leetcode._101_200._111;

import lintcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int minDepth(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        if ( root.left == null ) {
            return minDepth(root.right) + 1;
        }
        if ( root.right == null ) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deep = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            deep++;
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.poll();
                if (item.left == null && item.right == null) {
                    return deep;
                }
                if (item.left != null) {
                    queue.offer(item.left);
                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
            }
        }
        return deep;
    }

}
