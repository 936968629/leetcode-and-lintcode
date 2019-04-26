package lintcode._071;

import lintcode.TreeNode;

import java.util.*;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while ( !queue.isEmpty()){
            int size = queue.size();
            List<Integer> per = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode item = queue.poll();
                if (item != null){
                    per.add(item.val);
                    queue.offer(item.left);
                    queue.offer(item.right);

                }

            }
            if (!per.isEmpty()) {
                if (!flag){
                    Collections.reverse(per);
                }
                res.add(per);
            }
            flag = !flag;
        }
        return res;
    }

}
