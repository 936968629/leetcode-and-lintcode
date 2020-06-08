package lintcode._511;

import lintcode.ListNode;

public class Solution {

    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if ( head == null ) {
            return head;
        }
        ListNode v1Pre = null;
        ListNode v2Pre = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == v1) {
                v1Pre = cur;
            }
            if (cur.next.val == v2) {
                v2Pre = cur;
            }
            cur = cur.next;
        }

        if ( v1Pre == null || v2Pre == null ) {
            return head;
        }
        ListNode v1Node = v1Pre.next;
        ListNode v2Node = v2Pre.next;
        ListNode v1Next = v1Pre.next.next;
        ListNode v2Next = v2Pre.next.next;
        if ( v1Pre.next == v2Pre ) {
            // v1 -> v2
            v1Pre.next = v2Node;
            v2Node.next = v1Node;
            v1Node.next = v2Next;
        } else if ( v2Pre.next == v1Pre ) {
            v2Pre.next = v1Node;
            v1Node.next = v2Node;
            v2Node.next = v1Next;
        } else {
            v1Pre.next = v2Node;
            v2Node.next = v1Next;
            v2Pre.next = v1Node;
            v1Node.next = v2Next;
        }
        return dummy.next;
    }

    public ListNode findNodePre(ListNode head, int v) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while ( cur.next != null ) {
            if ( cur.next.val == v ) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

}
