package leetcode._501_600._530;

import lintcode.TreeNode;

public class Solution {

    private Integer min = Integer.MAX_VALUE;

    private Integer pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            pre = root.val;
        }else {
            min = Math.min(min, Math.abs(root.val - pre));
            pre = root.val;
        }
        dfs(root.right);
    }

}
