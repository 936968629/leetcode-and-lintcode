package leetcode._001_100._094;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if ( root == null ) {
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }

}
