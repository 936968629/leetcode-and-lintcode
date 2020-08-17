package leetcode._501_600._559;


import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    public int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(dfs(root.children.get(i)), max);
        }
        return max + 1;
    }

}
