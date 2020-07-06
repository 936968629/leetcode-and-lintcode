package leetcode._563;

import lintcode.TreeNode;

public class Solution {

    public int res = 0;

    public int findTilt(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
        res += Math.abs(left - right);
        findTilt(root.left);
        findTilt(root.right);
        return res;
    }

    public int getSum(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);

        return leftSum + rightSum + root.val;
    }

}
