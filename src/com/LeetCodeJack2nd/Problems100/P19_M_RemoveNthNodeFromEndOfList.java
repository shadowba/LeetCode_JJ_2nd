package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P19_M_RemoveNthNodeFromEndOfList {
    Map<Integer, ListNode> map;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int idx = 0;
        while (cur != null) {
            map.put(idx, cur);
            idx++;
            cur = cur.next;
        }
        int size = idx - 1;
        int prevIdx = size - n;
        int curIdx = prevIdx + 1;
        ListNode prev = map.get(prevIdx);
        ListNode target = map.get(curIdx);
        prev.next = target.next;
        target.next = null;
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
