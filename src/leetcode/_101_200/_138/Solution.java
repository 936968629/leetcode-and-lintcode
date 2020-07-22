package leetcode._101_200._138;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        head = copyNode(head);
        copyRandom(head);
        return split(head);
    }

    public Node copyNode(Node head) {
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            Node next = cur.next;
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        return head;
    }

    public void copyRandom(Node head) {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node random = cur.random;
            if (random == null) {
                next.random = null;
            }else {
                next.random = cur.random.next;
            }
            cur = next.next;
        }
    }

    public Node split(Node head) {
        Node dummy = new Node(1);
        Node cur = head;
        Node curNow = dummy;

        while (cur != null) {
            curNow.next = cur.next;
            curNow = curNow.next;
            cur.next = curNow.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
