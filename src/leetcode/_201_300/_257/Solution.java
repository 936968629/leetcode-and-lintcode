package leetcode._201_300._257;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(result, sb, root);
        return result;
    }

    public void dfs(List<String> result, StringBuilder item, TreeNode root) {
        if (root.left == null && root.right == null) {
            item.append(root.val);
            result.add(item.toString());
            item.delete(item.length()-String.valueOf(root.val).length(),item.length());
            return;
        }
        item.append(root.val).append("->");
        if (root.left != null) {
            dfs(result, item, root.left);
        }
        if (root.right != null) {
            dfs(result, item, root.right);
        }
        item.delete(item.length()-2-String.valueOf(root.val).length(), item.length());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        solution.binaryTreePaths(root);
    }

}
