package leetcode._101_200._145;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        result.add(root.val);
    }

}
