package lintcode._098;

import lintcode.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int minDepth(TreeNode root){

//        if (root == null){
//            return 0;
//        }
//        if (root.left == null){
//            return minDepth(root.right) + 1;
//        }
//        if (root.right == null){
//            return minDepth(root.left) + 1;
//        }
//        return Math.min(minDepth(root.right) + 1, minDepth(root.left) + 1);


        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int width = 1;
        while ( !queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.poll();
                if (item.left != null){
                    queue.offer(item.left);
                }
                if (item.right != null){
                    queue.offer(item.right);
                }
                if (item.left == null && item.right == null){
                    return width;
                }

            }
            width++;
        }
        return width;
    }

    public static void main(String[] args) {

    }

}
