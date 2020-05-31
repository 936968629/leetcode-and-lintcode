package lintcode._001_100._094;

import lintcode.TreeNode;

public class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        int leftMax = Math.max(0, helper(root.left));
        int rightMax = Math.max(0, helper(root.right));
        int local = Math.max(Math.max(leftMax + root.val, rightMax+root.val), root.val);
        max = Math.max(max, Math.max(local, leftMax + rightMax + root.val));
        return local;
    }

}
