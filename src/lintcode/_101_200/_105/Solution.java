package lintcode._101_200._105;

public class Solution {
    private class RandomListNode{
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null){
            return null;
        }
        head = copyNode(head);
        head = copyRandomNode(head);
        head = splitNode(head);
        return head;
    }

    public RandomListNode copyNode(RandomListNode head){
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode new_node = new RandomListNode(cur.label);
            new_node.next = cur.next;
            cur.next = new_node;
            cur = cur.next.next;
        }
        return head;
    }

    public RandomListNode copyRandomNode(RandomListNode head){
        RandomListNode cur = head;
        while (cur != null) {
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        return head;
    }

    public RandomListNode splitNode(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        dummy.next = head;
        RandomListNode cur =dummy;
        while (cur.next != null){
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
