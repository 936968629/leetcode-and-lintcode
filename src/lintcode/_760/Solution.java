package lintcode._760;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if ( root == null ){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.poll();
                if ( item.left != null ) {
                    queue.offer(item.left);
                }
                if ( item.right != null ) {
                    queue.offer(item.right);
                }
                if ( i == size - 1 ) {
                    result.add(item.val);
                }
            }
            
        }
        return result;
    }

}
