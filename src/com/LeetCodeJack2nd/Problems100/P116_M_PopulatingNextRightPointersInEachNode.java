package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P116_M_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int size=0;
        Node cur = root;
        while(!q.isEmpty()){
            size=q.size();
            while(size>0){
                cur = q.poll();
                if(q.peek()==null || size==1)
                    cur.next=null;
                else
                    cur.next=q.peek();
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
                size--;
            }
        }
        return root;
    }
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
