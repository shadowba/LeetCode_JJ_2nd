package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P102_M_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null)
            return resList;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = 0;
        List<Integer> curList;
        TreeNode node;
        while (!q.isEmpty()) {
            size = q.size();
            curList = new ArrayList<>();
            while (size > 0) {
                node = q.poll();
                curList.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                size--;
            }
            resList.add(new ArrayList<>(curList));
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
