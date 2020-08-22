package com.LeetCodeJack2nd.Problems100;

public class P114_M_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        root = flat(root);
    }

    private TreeNode flat(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;

        TreeNode temp = root.right;
        TreeNode cur = root;
        if (root.left != null) {
            root.right = flat(root.left);
            root.left = null;
            while (cur.right != null)
                cur = cur.right;
        }
        if (temp != null)
            cur.right = flat(temp);
        return root;
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
