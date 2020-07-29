package leetcode._101_200._129;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        return res;
    }

    public void dfs(StringBuilder item, TreeNode root) {
        if (root.left == null && root.right == null) {
            item.append(root.val);
            res += Integer.valueOf(item.toString());
            item.deleteCharAt(item.length()-1);
            return;
        }
        item.append(root.val);
        if (root.left != null) {
            dfs(item, root.left);
        }
        if (root.right != null) {
            dfs(item, root.right);
        }
        item.deleteCharAt(item.length()-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(solution.sumNumbers(root));
    }

}
