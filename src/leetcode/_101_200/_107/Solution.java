package leetcode._101_200._107;

import lintcode.TreeNode;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> resItem = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.poll();
                resItem.add(item.val);
                if (item.left != null) {
                    queue.offer(item.left);
                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
            }
            result.add(new ArrayList<>(resItem));
        }
        Collections.reverse(result);
        return result;
    }
}
