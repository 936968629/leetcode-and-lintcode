package leetcode._401_500._437;

import lintcode.TreeNode;

public class Solution {

    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return ;
        }
        if (target == root.val) {
            res++;
        }
        target -= root.val;
        dfs(root.left, target);
        dfs(root.right, target);
    }

}
