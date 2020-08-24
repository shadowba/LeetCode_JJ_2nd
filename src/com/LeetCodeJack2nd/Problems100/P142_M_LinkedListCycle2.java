package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P142_M_LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head==null)
            return null;
        while(fast!=null&&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow){
                ListNode slow2 = head;
                while(slow != slow2){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
