package lintcode._093;

import lintcode.TreeNode;

public class Solution {

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here

        if (root == null){
            return true;
        }

        int Hleft = getHeight(root.left);
        int Hright = getHeight(root.right);

        if (Math.abs(Hleft - Hright) <= 1){
            if (isBalanced(root.left) && isBalanced(root.right)){
                return true;
            }
        }

        return false;

    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int Hleft = getHeight(root.left) + 1;
        int Hright= getHeight(root.right) + 1;

        return Math.max(Hleft, Hright);
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
