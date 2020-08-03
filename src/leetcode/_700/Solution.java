package leetcode._700;

import lintcode.TreeNode;

public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.left != null && root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.right != null && root.val < val) {
            return searchBST(root.right,val);
        }
        return null;
    }

}
