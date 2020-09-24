package leetcode._201_300._297;

import lintcode.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(split));
        return helper(queue);
    }

    public TreeNode helper(Queue<String> queue) {
        String poll = queue.poll();
        if (poll.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(poll));
        treeNode.left = helper(queue);
        treeNode.right = helper(queue);
        return treeNode;
    }

}
