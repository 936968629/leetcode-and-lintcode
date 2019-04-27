package leetcode._138;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node cur = head;
        while (cur != null){
            Node new_node = new Node(cur.val, null, null);
            new_node.next = cur.next;
            cur.next = new_node;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null){
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        Node dummy = new Node(1, null, null);
        dummy.next = head;
        cur = dummy;
        while (cur.next != null){
            Node next = cur.next.next;
            cur.next = next;
            cur = cur.next;
        }
        return dummy.next;
    }

}
