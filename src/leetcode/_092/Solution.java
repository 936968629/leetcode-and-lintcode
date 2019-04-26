package leetcode._092;

import lintcode.ListNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        ListNode prevNode = null;
        ListNode nextNode = null;


        return null;


    }

    public int getLength(ListNode head){
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }


}
