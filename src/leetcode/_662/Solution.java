package leetcode._662;

import lintcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    class Command {
        public TreeNode node;
        public int index;
        public Command(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<Command> queue = new LinkedList<>();
        queue.offer(new Command(root, 0));

        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int length = queue.peekLast().index - queue.peekFirst().index + 1;
            res = Math.max(length, res);
            for (int i = 0; i < size; i++) {
                Command item = queue.poll();
                if (item.node.left != null) {
                    queue.offer(new Command(item.node.left, item.index * 2 + 1));
                }
                if (item.node.right != null) {
                    queue.offer(new Command(item.node.right, item.index * 2 + 2));
                }
            }
        }

        return res;
    }

}
