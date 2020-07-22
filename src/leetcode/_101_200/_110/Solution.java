package leetcode._101_200._110;

import lintcode.TreeNode;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = getLength(root.left);
        int rightH = getLength(root.right);
        if (Math.abs(leftH - rightH) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int getLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getLength(root.left);
        int rightH = getLength(root.right);
        return Math.max(leftH, rightH) + 1;
    }

}


