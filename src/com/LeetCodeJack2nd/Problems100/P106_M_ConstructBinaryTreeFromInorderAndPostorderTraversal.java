package com.LeetCodeJack2nd.Problems100;

public class P106_M_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight)
            return null;
        TreeNode root = new TreeNode(postorder[pRight]);
        int i = 0;
        for (i = iLeft; i <= iRight; i++) {
            if (postorder[pRight] == inorder[i])
                break;
        }
        root.left = helper(inorder, iLeft, i - 1, postorder, pLeft, pLeft + (i - iLeft) - 1);
        root.right = helper(inorder, i + 1, iRight, postorder, pLeft + (i - iLeft), pRight - 1);
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
