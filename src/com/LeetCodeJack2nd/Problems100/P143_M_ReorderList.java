package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P143_M_ReorderList {
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode fast= head;
        ListNode slow = head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        mid.next = reverse(mid.next);
        ListNode cur = head;
        ListNode cur1 = mid.next;
        ListNode next;
        ListNode next1;
        mid.next = null;
        while(cur!=null){
            next= cur.next;
            if(cur1==null)
                break;
            next1 = cur1.next;
            cur.next = cur1;
            cur1.next = next;
            cur = next;
            cur1 = next1;
        }
    }
    private ListNode reverse(ListNode head){
        if(head==null)
            return null;
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = cur.next;
        while(cur != null){
            next= cur.next;
            cur.next = prev;
            prev = cur;
            cur= next;
        }
        return prev;
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
