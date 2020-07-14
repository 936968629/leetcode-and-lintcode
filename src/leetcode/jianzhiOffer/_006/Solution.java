package leetcode.jianzhiOffer._006;

import lintcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> result = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        printListFromTailToHead(head);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void printListFromTailToHead(ListNode head) {
        if (head == null) {
            return;
        }

        // 如果有后继结点，就一直递归下去
        if (head.next != null) {
            printListFromTailToHead(head.next);
        }
        // 重点：在递归返回的时候把当前结点的值添加到结果列表中
        result.add(head.val);

    }
}
