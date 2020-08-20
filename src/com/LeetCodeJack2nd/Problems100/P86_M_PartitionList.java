package com.LeetCodeJack2nd.Problems100;

public class P86_M_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode lessDum = new ListNode(0);
        ListNode greatDum = new ListNode(0);
        ListNode lessCur = lessDum;
        ListNode greatCur = greatDum;
        ListNode temp;
        while (head != null) {
            temp = head.next;
            if (head.val >= x) {
                greatCur.next = head;
                head = temp;
                greatCur = greatCur.next;
                greatCur.next = null;
            } else {
                lessCur.next = head;
                head = temp;
                lessCur = lessCur.next;
                lessCur.next = null;
            }
        }
        lessCur.next = greatDum.next;
        return lessDum.next;
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
