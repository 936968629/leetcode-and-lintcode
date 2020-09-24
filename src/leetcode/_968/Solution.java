package leetcode._968;

import lintcode.TreeNode;

public class Solution {

    private int res = 0;

    public int minCameraCover(TreeNode root) {
        int status = dfs(root);
        if (status == 0) {
            res++;
        }
        return res;
    }

    /**
     * 0 未覆盖
     * 1 已覆盖
     * 2 监控节点
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 1 && right == 1) {
            return 0;
        }
        if (left == 0 || right == 0) {
            res++;
            return 2;
        }
        if (left + right >= 3) {
            return 0;
        }
        return -1;
    }

}
