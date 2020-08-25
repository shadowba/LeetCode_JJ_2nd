package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P199_M_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return resList;
        int size = 0;
        q.offer(root);
        TreeNode cur;
        while (!q.isEmpty()) {
            size = q.size();
            while (size > 0) {
                cur = q.poll();
                if (size == 1)
                    resList.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                size--;
            }
        }
        return resList;
    }

    private class TreeNode {
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

