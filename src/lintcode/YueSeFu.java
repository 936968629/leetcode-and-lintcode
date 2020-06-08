package lintcode;

import java.util.List;

public class YueSeFu {

    public int demo(int m, int n) {

        if ( m == 0 || n == 0 ) {
            return 0;
        }
        ListNode prev = createListNode(m);
        ListNode head = prev.next;
        ListNode cur = head;
        int count = 0;
        while ( cur.next != cur ) {
            count++;
            if (  count == n ) {
                prev.next = cur.next;
                count = 0;
            }else {
                prev = prev.next;
            }
            cur = cur.next;
        }

        System.out.println(cur.val+1);
        return cur.val + 1;
    }

    public ListNode createListNode(int m) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = cur.next;
        }
        cur.next = head;
        return cur;
    }


    public static void main(String[] args) {
        YueSeFu yueSeFu = new YueSeFu();
        yueSeFu.demo(3,2);
    }



}
