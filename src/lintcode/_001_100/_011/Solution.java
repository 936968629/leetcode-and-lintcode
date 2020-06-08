package lintcode._001_100._011;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if ( root == null ) {
            return res;
        }
        inorderTraversal(root,res,k1,k2);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root, List<Integer> res, int k1, int k2) {

        if (root.left != null){
            inorderTraversal(root.left, res,k1,k2);
        }
        if ( root.val >= k1 && root.val<=k2 ) {
            res.add(root.val);
        }
        if (root.right != null){
            inorderTraversal(root.right, res,k1,k2);
        }
        return res;
    }
}
