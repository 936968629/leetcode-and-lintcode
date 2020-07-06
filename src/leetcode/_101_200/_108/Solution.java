package leetcode._101_200._108;

import lintcode.TreeNode;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if ( length == 0 ){
            return null;
        }
        return helper(nums, 0, length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if ( left > right ) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid+1, right);
        return node;
    }

}
