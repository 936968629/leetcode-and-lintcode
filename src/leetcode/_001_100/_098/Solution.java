package leetcode._001_100._098;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> result = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        inorder(root);
        int prev = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) < prev) {
                return false;
            }
            prev = result.get(i);
        }
        return true;
    }

    public void inorder(TreeNode root) {
        if (root == null){
            return;
        }
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }


    public boolean isValidBST2(TreeNode root) {
        if (root == null){
            return true;
        }

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

}
