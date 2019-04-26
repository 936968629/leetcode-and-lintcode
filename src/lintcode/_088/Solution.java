package lintcode._088;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here

//        if (root == null || root == A || root == B){
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor(root.left, A, B);
//        TreeNode right = lowestCommonAncestor(root.right, A, B);
//
//        if (left != null && right != null){
//            return root;
//        }
//        if (left != null){
//            return left;
//        }
//        if (right != null){
//            return right;
//        }
//
//        return null;

        return null;
    }

    public boolean getPath(TreeNode root,TreeNode node,List<Integer> path){
        if(root==node) {
            path.add(root.val);
            return true;
        }
        path.add(root.val);
        boolean found = false;
        if(root.left!=null) {
            found = getPath(root.left,node,path);
        }
        if(!found && root.right!=null) {
            found = getPath(root.right,node,path);
        }
        if ( !found ){
            path.remove(path.size()-1);
        }

        return false;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> list = new ArrayList<>();
        Solution sol = new Solution();
        sol.getPath(root, root.right, list);
        System.out.println(list.toString());
    }
}
