package leetcode._101_200._116;

public class Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        helper(root.left, root.right);
        return root;
    }

    public void helper(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return;
        }
        t1.next = t2;
        helper(t1.left, t1.right);
        helper(t2.left, t2.right);
        helper(t1.right, t2.left);
    }
}
