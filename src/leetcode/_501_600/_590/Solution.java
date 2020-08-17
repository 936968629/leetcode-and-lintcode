package leetcode._501_600._590;

import java.util.ArrayList;
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

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return result;
        }
        dfs(root);
        return result;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i));
        }
        result.add(root.val);
    }

}
