package lintcode._094;

import lintcode.TreeNode;

public class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null){
            return -1;
        }
        
        dfs(root);
        return max;

    }

    public int dfs(TreeNode root){

        if (root == null){
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        int localMax = Math.max(Math.max(leftMax, rightMax) + root.val, root.val);
        max = Math.max(max, Math.max(localMax, leftMax + rightMax + root.val));
        return localMax;

    }

}
