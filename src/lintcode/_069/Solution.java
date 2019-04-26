package lintcode._069;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
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
            if(per.size() != 0) {
                res.add(per);
            }
        }
        return res;
    }

}
