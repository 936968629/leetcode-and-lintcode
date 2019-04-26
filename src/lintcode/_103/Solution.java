package lintcode._103;

import lintcode.ListNode;
import lintcode.TreeNode;

public class Solution {

    class Command{
        boolean isCycle;
        ListNode slow;

        public Command(boolean isCycle, ListNode slow){
            this.isCycle = isCycle;
            this.slow = slow;
        }
    }

    public ListNode detectCycle(ListNode head) {
        // write your code here
        Command command = isCycle(head);
        if ( command.isCycle){
            ListNode slow = command.slow;
            ListNode cur = head;
            while (cur != null){
                if (cur == slow){
                    return slow;
                }
                cur = cur.next;
                slow = slow.next;
            }
        }
        return null;
    }

    public Command isCycle(ListNode head){
        if (head == null){
            return new Command(false, null);
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return new Command(true, slow);
            }
        }
        return new Command(false, null);
    }
}
