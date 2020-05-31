package lintcode._301_400._372;

public class Solution {

    public void deleteNode(ListNode node) {
        // write your code here

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;

    }

}
