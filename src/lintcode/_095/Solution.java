package lintcode._095;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if ( root == null ) {
            return true;
        }
        inorder(root, res);
        int last = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            if ( res.get(i) <= last ) {
                return false;
            }
            last = res.get(i);
        }
        return true;

    }

    public void inorder(TreeNode root, List<Integer> res) {
        if ( root.left != null ) {
            inorder(root.left, res);
        }
        res.add(root.val);
        if ( root.right != null ) {
            inorder(root.right, res);
        }
    }

}
