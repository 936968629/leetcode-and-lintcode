package leetcode._101_200._112;

import lintcode.TreeNode;

public class Solution {

    private boolean res  = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root.left == null && root.right == null) {
            target = target - root.val;
            if (target == 0) {
                res = true;
            }
            target += root.val;
            return;
        }
        target = target - root.val;
        if (root.left != null) {
            dfs(root.left, target);
        }
        if (root.right != null) {
            dfs(root.right, target);
        }
        target += root.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        solution.hasPathSum(root, 4);
    }
}
