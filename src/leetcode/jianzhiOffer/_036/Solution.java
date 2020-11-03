package leetcode.jianzhiOffer._036;

public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node prev = null;
    public Node head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);

        head.left = prev;
        prev.right = head;
        return head;
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev == null) {
            head = root;
        }else {
            prev.right = root;
        }
        root.left = prev;
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(5);
        solution.treeToDoublyList(node);
    }
}
