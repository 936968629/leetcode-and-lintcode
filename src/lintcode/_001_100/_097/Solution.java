package lintcode._001_100._097;

import lintcode.TreeNode;

public class Solution {

    public int maxDepth(TreeNode root){

        if (root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left) + 1;
        int rightHeight = maxDepth(root.right) + 1;


        return Math.max(leftHeight,rightHeight);

    }

}
