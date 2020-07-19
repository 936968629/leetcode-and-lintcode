package leetcode._138;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        head = copyNode(head);
        copyRandom(head);
        Node remove = remove(head);
        return remove.next;
    }

    public Node copyNode(Node head) {
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(head.val);
            Node next = cur.next;
            cur.next = newNode;
            newNode.next = next;
            cur = cur.next.next;
        }
        return head;
    }

    public void copyRandom(Node head) {
        Node cur = head;
        while (cur != null) {
            Node random = cur.random;
            Node next = cur.next;
            if (random == null) {
                next.random = null;
            }else {
                next.random = random.next;
            }
            cur = next.next;
        }

    }

    public Node remove(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cur = dummy;
        while (cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy;
    }
}
