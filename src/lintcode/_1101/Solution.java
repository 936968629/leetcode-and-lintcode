package lintcode._1101;

import lintcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    class Command {
        int index;
        TreeNode node;
        public Command(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // Write your code here
        int max = 0;
        if ( root == null ) {
            return 0;
        }

        Queue<Command> queue = new LinkedList<>();
        Command command = new Command(0, root);
        queue.offer(command);

        while ( !queue.isEmpty() ) {
            int size = queue.size();
            max = Math.max(max, ((LinkedList<Command>) queue).peekLast().index - ((LinkedList<Command>) queue).peekFirst().index + 1);
            for (int i = 0; i < size; i++) {
                Command item = queue.poll();
                if ( item.node.left != null ) {
                    queue.offer(new Command(item.index*2 + 1, item.node.left));
                }
                if ( item.node.right != null ) {
                    queue.offer(new Command(item.index*2+2, item.node.right));
                }

            }

        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        int i = solution.widthOfBinaryTree(root);
        System.out.println(i);
    }
}
