package lintcode._101_200._174;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n){
        int length = 0;
        ListNode len_cur = head;
        while (len_cur != null) {
            length++;
            len_cur = len_cur.next;
        }
        if (length == 0){
            return head;
        }
        if (n > length){
            return head;
        }
        if (n == length){
            return head.next;
        }
        ListNode cur = head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return cur;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        assert false;
        System.out.println(11);
    }

}
