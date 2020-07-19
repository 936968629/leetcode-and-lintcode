package leetcode.jianzhiOffer._0201;

import lintcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        ListNode cur = head.next;
        set.add(prev.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                ListNode next = cur.next;
                prev.next = next;
                cur = next;
            }else {
                set.add(cur.val);
                prev = cur;
                cur = cur.next;

            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        solution.removeDuplicateNodes(head);
    }

}
