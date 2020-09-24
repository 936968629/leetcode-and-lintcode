package leetcode._101_200._114;

import lintcode.TreeNode;

public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        root.left = null;
        root.right = leftNode;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = rightNode;
    }

}
