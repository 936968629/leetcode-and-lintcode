package leetcode.jianzhiOffer._027;

import lintcode.TreeNode;

public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        root.left = rightNode;
        root.right = leftNode;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

}
