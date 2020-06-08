package lintcode._001_100._071;

import lintcode.TreeNode;

import java.util.*;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null ) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            List<Integer> itemRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.poll();
                itemRes.add(item.val);
                if ( item.left == null ) {
                    queue.offer(item.left);
                }
                if ( item.right == null ) {
                    queue.offer(item.right);
                }
            }
            if ( flag % 2 == 0 ) {
                Collections.reverse(itemRes);
            }
            flag++;
            result.add(itemRes);
        }
        return result;
    }

}
