package leetcode._201_300._222;

import lintcode.TreeNode;

public class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = 0;
        TreeNode cur = root;
        while (cur != null) {
            leftH++;
            cur = cur.left;
        }
        int rightH = 0;
        cur = root;
        while (cur != null) {
            rightH++;
            cur = cur.right;
        }
        if (leftH == rightH) {
            return (int)Math.pow(2, leftH) - 1;
        }else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
