package leetcode._301_400._337;

import lintcode.TreeNode;

public class Solution {

    // root节点强最大值
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(robCur(root), noRobCur(root));
    }

    public int robCur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + noRobCur(root.left) + noRobCur(root.right);
    }

    public int noRobCur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rob(root.left) + rob(root.right);
    }
}
