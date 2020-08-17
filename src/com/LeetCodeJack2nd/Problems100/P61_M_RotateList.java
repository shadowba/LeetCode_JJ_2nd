package com.LeetCodeJack2nd.Problems100;

public class P61_M_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(0);
        int num = 1;

        while (fast.next != null) {
            num++;
            fast = fast.next;
        }
        int idx = (k >= num) ? num - k % num : num - k;
        if (idx == num) return head;
        int i =1;
        while (i<idx) {
            i++;
            slow = slow.next;
        }


        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        head = dummy.next;
        return head;
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
