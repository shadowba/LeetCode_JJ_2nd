package com.LeetCodeJack2nd.Problems100;

public class P98_M_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long minLimit, long maxLimit) {
        if (node == null)
            return true;

        boolean res = true;
        res &= helper(node.left, minLimit, node.val);
        res &= (minLimit < node.val && node.val < maxLimit)? true : false;
        res &= helper(node.right, node.val, maxLimit);

        return res;
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
