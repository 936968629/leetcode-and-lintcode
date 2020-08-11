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
        if (leftNode != null) {
            TreeNode cur = leftNode;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = root.right;
            root.right = leftNode;
            root.left = null;
        }
    }

}
