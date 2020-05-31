package lintcode._001_100._007;

import lintcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder res = new StringBuilder();
        res.append("{");
        if (root == null) {
            res.append("#}");
            return res.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.poll();
                if ( item == null ) {
                    res.append("#");
                    res.append(",");
                    continue;
                }
                queue.offer(item.left);
                queue.offer(item.right);
                res.append(item.val);
                res.append(",");
            }
        }

        for (int i = res.length() - 1; i >= 0; i--) {
            if (res.charAt(i) == '#' || res.charAt(i) == ',') {
                res.deleteCharAt(i);
            } else {
                break;
            }
        }

        res.append('}');
        return res.toString();
    }


    public TreeNode deserialize(String data) {
        // write your code here
        String content = data.substring(1, data.length() - 1);
        if ( content.isEmpty() ) {
            return null;
        }
        String[] split = content.split(",");
        TreeNode[] node  = new TreeNode[split.length];
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("#")) {
                continue;
            } else {
                node[i] = new TreeNode(Integer.valueOf(split[i]));
            }
        }
        int skip = 0;
        for (int i = 0; i < split.length; i++) {
            if (node[i] == null) {
                skip++;
                continue;
            }

            int leftIndex = i * 2 + 1 - 2 * skip;
            if (leftIndex < split.length) {
                node[i].left = node[leftIndex];
            }

            int rightIndex = i * 2 + 2 - 2 * skip;
            if (rightIndex < split.length) {
                node[i].right = node[rightIndex];
            }
        }

        return node[0];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.left.left = new TreeNode(10);
        String serialize = solution.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = solution.deserialize(serialize);

    }
}
