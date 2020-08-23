package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P138_M_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        if (head == null)
            return null;
        Node cur = head;
        Node newCur;
        while (cur != null) {
            if (!map.containsKey(cur))
                map.put(cur, new Node(cur.val));
            newCur = map.get(cur);

            if (cur.next != null) {
                if (!map.containsKey(cur.next))
                    map.put(cur.next, new Node(cur.next.val));
                newCur.next = map.get(cur.next);
            } else
                newCur.next = null;

            if (cur.random != null) {
                if (!map.containsKey(cur.random))
                    map.put(cur.random, new Node(cur.random.val));
                newCur.random = map.get(cur.random);
            } else
                newCur.random = null;
            cur = cur.next;
        }
        return map.get(head);
    }


    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
