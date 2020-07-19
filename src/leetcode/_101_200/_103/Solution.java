package leetcode._101_200._103;

import lintcode.ListNode;
import lintcode.TreeNode;

import java.util.*;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sign = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                item.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sign % 2 == 1) {
                result.add(new ArrayList<>(item));
            }else {
                Collections.reverse(item);
                result.add(new ArrayList<>(item));
            }
            sign++;
        }

        return result;
    }

}
