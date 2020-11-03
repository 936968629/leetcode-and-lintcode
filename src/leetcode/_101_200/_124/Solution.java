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
        int val = root.val;
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        max = Math.max(max,  leftMax + rightMax + val);
        return val + Math.max(leftMax, rightMax);
    }


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        System.out.println(map.get("dsa"));
    }
}
