package leetcode._101_200._104;

import lintcode.TreeNode;

public class Solution {

    public int maxDepth(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        return getHeight(root);
    }

    public int getHeight(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
