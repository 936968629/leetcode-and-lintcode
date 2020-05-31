package lintcode._001_100._068;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> prorderTraversal(TreeNode root) {
        // write your code here
        if ( root == null ) {
            return null;
        }
        helper(root);
        return result;
    }

    public void helper(TreeNode root) {
        if ( root == null ) {
            return;
        }
        helper(root.left);
        helper(root.right);
        result.add(root.val);
    }
}
