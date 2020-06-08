package lintcode._726;

import lintcode.TreeNode;

public class Solution {

    public boolean isFullTree(TreeNode root) {
        // write your code here
        if ( root.left == null && root.right == null ) {
            return true;
        }
        if ( root.left != null && root.right != null ) {
            return isFullTree(root.left) && isFullTree(root.right);
        }
        return false;
    }

}
