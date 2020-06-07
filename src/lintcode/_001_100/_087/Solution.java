package lintcode._001_100._087;

import lintcode.TreeNode;

public class Solution {

    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if ( root == null ) {
            return null;
        }
        if ( value < root.val ) {
            root.left = removeNode(root.left, value);
        } else if ( value > root.val ) {
            root.right = removeNode(root.right, value);
        } else {
            // ==
            if ( root.left == null && root.right == null) {
                return null;
            }
            if ( root.left == null ) {
                TreeNode temp = root.right;
                return temp;
            } else if ( root.right == null ) {
                TreeNode temp = root.left;
                return temp;
            } else {
                TreeNode rightMin = findRightMin(root.right);
                root.val = rightMin.val;
                root.right = removeNode(root.right, rightMin.val);
            }

        }
        return root;
    }

    public TreeNode findRightMin(TreeNode root) {
        if ( root == null ) {
            return null;
        }
        if ( root.left == null ) {
            return root;
        }
        return findRightMin(root.left);
    }
}
