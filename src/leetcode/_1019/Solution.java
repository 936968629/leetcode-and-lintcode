package leetcode._1019;

import lintcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        List<Integer> result = new ArrayList<>();
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        ListNode reverse = reverse(head);

        ListNode cur = reverse;
        int index = 0;
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek() <= cur.val) {
                stack.pop();
            }
            result.add(stack.isEmpty() ? 0 : stack.peek());
            stack.push(cur.val);
            index++;
            cur = cur.next;
        }
        Collections.reverse(result);
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}
