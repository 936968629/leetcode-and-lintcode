package leetcode.jianzhiOffer._054;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        this.k = k;
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root.right != null) {
            helper(root.right);
        }
        k--;
        if (k == 0) {
            res = root.val;
            return;
        }
        if (root.left != null) {
            helper(root.left);
        }
    }

    private int mink;

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return -1;
        }
        this.mink = k;
        dfs(root, result);
        return result.get(k-1);
    }

    public void dfs(TreeNode root,  List<Integer> result) {
        if (result.size() >= mink) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            dfs(root.right, result);
        }
    }
}
