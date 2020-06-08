package lintcode._101_200._104;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        int length = lists.size();
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists.get(0);
        }
        return this.mergeKListsMethod(lists, 0, length - 1);

    }

    public ListNode mergeKListsMethod(List<ListNode> lists, int start, int end){

        if (start == end) {
            return lists.get(start);
        }
        if (start + 1 == end){
            return this.mergeTwoList(lists.get(start), lists.get(end));
        }
        int mid = start + (end - start) / 2;
        return mergeTwoList(mergeKListsMethod(lists, start, mid), mergeKListsMethod(lists, mid+1, end));
    }


    public ListNode mergeTwoList(ListNode l1, ListNode l2){

        ListNode head = new ListNode(1);
        ListNode cur = head;
        while ( l1 != null && l2 != null ) {

            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null)
            cur.next = l1;
        if (l2 != null){
            cur.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<ListNode> lists = new ArrayList<>();
        sol.mergeKLists(lists);
    }

}
