package lintcode._401_500._453;

import lintcode.TreeNode;

public class Solution {

    public TreeNode lastNode;

    public void flatten(TreeNode root) {
        // write your code here
        if ( root == null ) {
            return;
        }
        helper(root);
    }

    public void helper(TreeNode root) {
        if ( root == null ) {
            return;
        }

        if ( lastNode != null ) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        helper(lastNode.left);
        helper(right);
    }
}
