package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P103_M_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null)
            return resList;

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> curList = new LinkedList<>();
        int size = 0;
        int level = 0;
        TreeNode cur;
        q.offer(root);

        while (!q.isEmpty()) {
            size = q.size();
            level++;
            while (size > 0) {
                cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                if (level % 2 == 1)
                    curList.add(cur.val);
                else
                    curList.add(0, cur.val);
                size--;
            }
            resList.add(new ArrayList<>(curList));
            curList.clear();
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
