package com.LeetCodeJack2nd.Problems100;

public class P2_M_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 != null) ? l1 : l2;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = carry + l1.val + l2.val;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        cur.next = (l1 != null) ? l1 : l2;
        ListNode prev = cur;
        cur = cur.next;
        while (cur != null) {
            sum = cur.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev = cur;
            cur = cur.next;
        }
        if (carry == 1&& cur == null)
            prev.next = new ListNode(1);

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
