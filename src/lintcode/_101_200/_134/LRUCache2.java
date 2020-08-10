package lintcode._101_200._134;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public int capcity;

    public Map<Integer, Node> map;

    public Node head;

    public Node tail;

    private int size;

    public LRUCache2(int capcity) {
        this.capcity = capcity;
        this.map = new HashMap<>(2 * capcity);
        this.head = this.tail = null;
        size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if ( node == null ) {
            return -1;
        }
        removeNode(node);
        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if ( node == null ) {
            //新节点
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if ( size == capcity ) {
                map.remove(tail.key);
                removeNode(tail);
                moveToHead(newNode);
            } else {
                moveToHead(newNode);
                size++;
            }
        } else {
            //老节点 修改为新的值
            node.value = value;
            removeNode(node);
            moveToHead(node);
        }

    }

    private void removeNode(Node node) {
        if ( head == tail ) {
            head = tail = null;
        } else {
            if ( head == node ) {
                head = head.next;
                node.next = null;
                head.prev = null;
            } else if ( tail == node ) {
                tail = tail.prev;
                node.prev = null;
                tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }
        }

    }

    private void moveToHead(Node node) {
        if ( head == null ) {
            head = tail = node;
            return;
        }
        if ( head == node ) {
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;

    }

    public static void main(String[] args) {
        LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.set(2, 21);
        lruCache2.set(1, 1);
        lruCache2.get(2);
        lruCache2.set(4,4);
        lruCache2.get(1);
        lruCache2.get(2);
    }
}
