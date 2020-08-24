package com.LeetCodeJack2nd.Problems100;

public class P147_M_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode temp = head;
        ListNode next;
        ListNode prev;
        while (head != null) {
            temp = head.next;
            cur = dummy;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            prev = cur.next;
            cur.next = head;
            cur.next.next = prev;
            head = temp;
        }
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
