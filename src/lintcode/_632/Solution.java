package lintcode._632;

import lintcode.TreeNode;

public class Solution {

    public int max = Integer.MIN_VALUE;

    public TreeNode maxNode(TreeNode root) {
        // write your code here
        if ( root == null ) {
            return null;
        }
        helper(root);
        return new TreeNode(max);
    }

    public void helper(TreeNode root) {
        if ( root == null ) {
            return;
        }
        if ( root.val > max ) {
            max = root.val;
        }
        helper(root.left);
        helper(root.right);
    }

}
