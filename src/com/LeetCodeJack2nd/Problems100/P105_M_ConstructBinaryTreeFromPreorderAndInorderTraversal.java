package com.LeetCodeJack2nd.Problems100;

public class P105_M_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight){
        if(iLeft>iRight||pLeft>pRight)
            return null;

        TreeNode root = new TreeNode(preorder[pLeft]);
        int i = 0;
        for(i=iLeft; i<=iRight; i++){
            if(inorder[i]==preorder[pLeft])
                break;
        }
        root.left = helper(preorder, inorder, pLeft+1, pLeft+(i-iLeft), iLeft, i-1);
        root.right = helper(preorder, inorder, pLeft+(i-iLeft)+1, pRight, i+1, iRight);
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
