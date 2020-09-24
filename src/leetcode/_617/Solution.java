package leetcode._617;

import lintcode.TreeNode;

public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        return helper(t1, t2);
    }

    public TreeNode helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }

        t1.val = t1.val + t2.val;
        TreeNode left = helper(t1.left, t2.left);
        TreeNode right = helper(t1.right, t2.right);
        t1.left = left;
        t1.right = right;
        return t1;
    }

}
