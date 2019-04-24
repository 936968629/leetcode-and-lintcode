package lintcode._094;

import lintcode.TreeNode;

public class Solution {
<<<<<<< HEAD
	
	int max = Integer.MIN_VALUE;
=======

    int max = Integer.MIN_VALUE;
>>>>>>> 90043515c2c99e1e7490b18c478cac5f3f9a7240

    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null){
<<<<<<< HEAD
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
		
		int local_max = Math.max(Math.max(leftMax + root.val, rightMax + root.val), root.val);
		max = Math.max(max, Math.max(local_max, leftMax+rightMax+root.val));
		
        return local_max;
=======
            return 0;
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

>>>>>>> 90043515c2c99e1e7490b18c478cac5f3f9a7240
    }

}
