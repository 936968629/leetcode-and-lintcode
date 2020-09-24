package leetcode._301_400._382;

import lintcode.ListNode;

import java.util.Random;

public class Solution {

    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random();
        ListNode cur = head;

        boolean isFool = false;
        int count = 0;
        int res = -1;
        while (cur != null) {
            count++;
            if (!isFool) {
                res = cur.val;
                isFool = true;
            }else {
                int i = random.nextInt(count);
                if (i == 0) {
                    res = cur.val;
                }
            }
            cur = cur.next;
        }

        return res;
    }

}
