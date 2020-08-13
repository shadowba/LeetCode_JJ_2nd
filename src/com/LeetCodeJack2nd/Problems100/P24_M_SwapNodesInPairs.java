package com.LeetCodeJack2nd.Problems100;

public class P24_M_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur= dummy;
        ListNode temp;
        ListNode temp2;
        while(cur!=null && cur.next!=null && cur.next.next!=null){
            temp = cur.next.next.next;
            cur.next.next.next = cur.next;
            temp2 = cur.next;
            cur.next = temp2.next;
            cur.next.next.next = temp;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
