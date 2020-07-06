package leetcode._543;

import lintcode.TreeNode;

public class Solution {

    public int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        getHeight(root);
        return max;
    }

    public int getHeight(TreeNode node) {

        if ( node == null ) {
            return 0;
        }
        int leftH = getHeight(node.left);
        int rightH = getHeight(node.right);

        if ( leftH + rightH > max ) {
            max = leftH + rightH;
        }
        return Math.max(leftH , rightH) + 1;
    }

}
