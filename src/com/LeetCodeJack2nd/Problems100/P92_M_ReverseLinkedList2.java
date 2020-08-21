package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P92_M_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int idx = 0;
        while (cur != null) {
            map.put(idx, cur);
            idx++;
            cur = cur.next;
        }
        int length = idx-1;
        ListNode newDum = new ListNode(0);
        cur = newDum;
        for(int i = n; i>=m;i--){
            map.get(i).next = null;
            cur.next = map.get(i);
            cur=cur.next;
        }
        if(n+1<=length)
            cur.next = map.get(n+1);
        if(m-1>=0)
            map.get(m-1).next = newDum.next;

        return dummy.next;
    }

    private class ListNode {
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
