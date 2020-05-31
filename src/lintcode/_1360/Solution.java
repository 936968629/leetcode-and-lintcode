package lintcode._1360;

import lintcode.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if ( root == null ) {
            return true;
        }

        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {

        if ( left == null && right == null ) {
            return true;
        }
        if ( left == null || right == null ) {
            return false;
        }
        if ( left.val == right.val ) {
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
        return false;
    }

}
