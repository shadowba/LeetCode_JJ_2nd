package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P144_M_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null)
            return resList;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cur);
        while(!stack.isEmpty()){
            while(cur!=null){
                resList.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
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

//    ---  Recursive Method   ---
//    List<Integer> resList;
//    public List<Integer> preorderTraversal(TreeNode root) {
//        resList = new ArrayList<>();
//        if(root == null)
//            return resList;
//        helper(root);
//        return resList;
//    }
//    private void helper(TreeNode root){
//        if(root == null)
//            return;
//        resList.add(root.val);
//        helper(root.left);
//        helper(root.right);
//    }
