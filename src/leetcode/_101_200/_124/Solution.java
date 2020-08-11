package leetcode._101_200._124;

import lintcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int maxSum = root.val + Math.max(0, left) + Math.max(0, right);
        max = Math.max(max, maxSum);
        return root.val + Math.max(Math.max(left, right), 0);
    }


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.get("dsa"));
    }
}
