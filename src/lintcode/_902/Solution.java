package lintcode._902;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        inorder(root, list, k);
        return list.get(k-1);

    }

    public void inorder(TreeNode root, List<Integer> list, int k){
        if (root == null){
            return;
        }
        if ( list.size() == k ) {
            return;
        }
        inorder(root.left, list, k);
        list.add(root.val);
        inorder(root.right, list, k);
    }
}




