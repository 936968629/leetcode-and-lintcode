package lintcode._001_100._085;

import lintcode.TreeNode;

public class Solution {

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if ( root == null ) {
            return node;
        }
        if ( node.val < root.val ) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }

}
