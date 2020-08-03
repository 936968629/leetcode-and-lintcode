package leetcode._988;

import lintcode.TreeNode;

public class Solution {

    private String res = "~";

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return res;
    }

    public void dfs(TreeNode root, StringBuilder item) {
        if (root.left == null && root.right == null) {
            item.append((char)('a' + root.val));
            item.reverse();
            String S = item.toString();
            item.reverse();
            if (S.compareTo(res) < 0) {
                res = S;
            }
            item.deleteCharAt(item.length()-1);
        }
        item.append((char)('a' + root.val));
        if (root.left != null) {
            dfs(root.left, item);
        }
        if (root.right != null) {
            dfs(root.right, item);
        }
        item.deleteCharAt(item.length()-1);
    }

}
