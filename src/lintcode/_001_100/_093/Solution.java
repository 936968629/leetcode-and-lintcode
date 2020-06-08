package lintcode._001_100._093;

import lintcode.TreeNode;

public class Solution {

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if ( root == null ) {
            return true;
        }
        int rightHeight = getHeight(root.right);
        int leftHeight = getHeight(root.left);
        if (Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int Hleft = getHeight(root.left) + 1;
        int Hright= getHeight(root.right) + 1;

        return Math.max(Hleft, Hright);
    }

    public boolean isBalanced2(TreeNode root) {
        if ( root == null) {
            return true;
        }
        return helper(root);
    }

    public boolean helper(TreeNode root) {
        if ( root == null ) {
            return true;
        }
        if ( Math.abs(height(root.left) - height(root.right)) > 1 ) {
            return false;
        }
        if ( helper(root.left) && helper(root.right) ) {
            return true;
        }
        return false;
    }

    public int height(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        int heightLeft = height(root.left) + 1;
        int heightRight = height(root.right) + 1;

        return Math.max(heightLeft, heightRight);
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);

        System.out.println(sol.isBalanced(root));
    }
}
