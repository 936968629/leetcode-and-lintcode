package leetcode._654;

import lintcode.TreeNode;

public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return null;
        }
        return dfs(nums, 0, length - 1);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = findMax(nums, left, right);

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = dfs(nums, left, maxIndex - 1);
        root.right = dfs(nums, maxIndex + 1, right);
        return root;
    }

    public int findMax(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
