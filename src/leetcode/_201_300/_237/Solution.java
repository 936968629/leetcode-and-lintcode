package leetcode._201_300._237;

import lintcode.ListNode;

public class Solution {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

}
