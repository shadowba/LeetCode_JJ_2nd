package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P94_M_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        if (root == null)
            return resList;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            resList.add(cur.val);
            cur = cur.right;
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

//    List<Integer> resList;
//    public List<Integer> inorderTraversal(TreeNode root) {
//        resList = new ArrayList<>();
//        if(root == null)
//            return resList;
//        helper(root);
//        return resList;
//    }
//    private void helper(TreeNode root){
//        if(root == null)
//            return;
//        helper(root.left);
//        resList.add(root.val);
//        helper(root.right);
//    }
