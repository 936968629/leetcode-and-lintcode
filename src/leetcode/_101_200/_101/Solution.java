package leetcode._101_200._101;

import lintcode.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {

        return helper(root, root);
    }

    public boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return helper(p.left, q.right) && helper(p.right, q.left);
    }

}
