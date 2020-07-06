package leetcode._101_200._102;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null ) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while ( !queue.isEmpty() ) {
            int size = queue.size();
            List<Integer> itemList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.poll();
                itemList.add(item.val);
                if ( item.left != null ) {
                    queue.offer(item.left);
                }
                if ( item.right != null ) {
                    queue.offer(item.right);
                }
            }
            res.add(new ArrayList<>(itemList));
        }

        return res;
    }

}
