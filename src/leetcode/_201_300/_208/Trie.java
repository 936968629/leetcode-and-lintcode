package leetcode._201_300._208;

public class Trie {

    class Node{
        public char val;
        public Node[] child;
        public boolean isEnd;

        public Node() {
//            this.val = val;
            this.isEnd = false;
            this.child = new Node[26];
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char item = word.charAt(i);
            if (node.child[item - 'a'] == null) {
                node.child[item - 'a'] = new Node();
            }
            node = node.child[item - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char item = word.charAt(i);
            if (node.child[item - 'a'] == null) {
                return false;
            }
            node = node.child[item - 'a'];
        }
        if (node.isEnd) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char item = prefix.charAt(i);
            if (node.child[item - 'a'] == null) {
                return false;
            }
            node = node.child[item - 'a'];
        }
        return true;
    }

}
