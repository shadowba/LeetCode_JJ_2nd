package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P173_M_BinarySearchTreeIterator {
    Queue<Integer> q;

    public P173_M_BinarySearchTreeIterator(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        q = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            q.offer(cur.val);
            cur = cur.right;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return q.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !q.isEmpty();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
