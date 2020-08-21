package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P95_M_UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left;
        List<TreeNode> right;
        for (int i = start; i <= end; i++) {
            left = helper(start, i - 1);
            right = helper(i + 1, end);
            for (TreeNode a : left) {
                for (TreeNode b : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = a;
                    node.right = b;
                    list.add(node);
                }
            }
        }
        return list;
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
