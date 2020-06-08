package lintcode._595;

import lintcode.TreeNode;

public class Solution {

    public int longestConsecutive(TreeNode root) {
        // write your code here
        if ( root == null ) {
            return 0;
        }

        return helper(root, null, 0);
    }

    public int helper(TreeNode root, TreeNode parent, int item) {
        if ( root == null ) {
            return 0;
        }
        int length = (parent != null && parent.val + 1 == root.val) ? item + 1 : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }

}
