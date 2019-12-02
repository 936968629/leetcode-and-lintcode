package lintcode._902;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k-1);

    }

    public void inorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}




