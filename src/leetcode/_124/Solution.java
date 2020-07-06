package leetcode._124;

import lintcode.TreeNode;

public class Solution {

    public int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int maxSum = root.val + Math.max(0, left) + Math.max(0, right);
        res = Math.max(res, maxSum);
        return root.val + Math.max(0, Math.max(left, right));
    }

}
