package lintcode._101_200._175;

import lintcode.TreeNode;

public class Solution {

    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if ( root == null ) {
            return;
        }
        heleper(root);

    }

    public void heleper(TreeNode root) {
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = rightNode;
        if ( root.left != null ) {
            heleper(root.left);
        }
        if ( root.right != null ) {
            heleper(root.right);
        }
    }
}
