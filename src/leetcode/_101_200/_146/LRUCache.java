package leetcode._101_200._146;

import java.util.HashMap;

public class LRUCache {

    class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public int capcity;

    public HashMap<Integer, Node> map;

    public Node head;

    public Node tail;

    public int size;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        head = tail = null;
        this.capcity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //删除节点 该节点移到头结点
        removeNode(map.get(key));
        moveToHead(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //移到头结点
            Node curNode = map.get(key);
            curNode.val = value;
            removeNode(curNode);
            moveToHead(curNode);
            return;
        }
        //新增节点
        if (size == capcity) {
            //删除最后一个节点
            map.remove(tail.key);
            removeNode(tail);
        }else {
            size++;
        }

        //新增
        Node node = new Node(key, value);
        map.put(key, node);
        moveToHead(node);

    }

    private void removeNode(Node node) {
        if (head == tail) {
            head = tail = null;
            return;
        }
        if (head == node) {
            head = node.next;
            head.prev = null;
            node.next = null;
            return;
        }
        if (tail == node) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void moveToHead(Node node) {
        if (head == null) {
            head = tail = node;
            return;
        }
        if (head == node) {
            return;
        }
        Node curHead = head;
        node.next = curHead;
        curHead.prev = node;
        head = node;
    }

    public static void main(String[] args) {
//        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

}
