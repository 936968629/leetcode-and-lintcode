package leetcode._201_300._230;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> result = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {

        inorder(root);
        return result.get(k-1);
    }

    public void inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorder(root.right);
        }
    }

}
