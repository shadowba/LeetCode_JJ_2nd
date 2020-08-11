package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P113_M_PathSum2 {
    List<List<Integer>> resList;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        resList = new ArrayList<>();
        if (root == null)
            return resList;
        int curSum = 0;
        List<Integer> curList = new ArrayList<>();
        sumDFS(root, curSum, curList, sum);
        return resList;
    }

    private void sumDFS(TreeNode cur, int curSum, List<Integer> curList, int sum) {
        if (cur.left == null && cur.right == null) {
            if ((curSum + cur.val) == sum) {
                curList.add(cur.val);
                resList.add(new ArrayList<>(curList));
                curList.remove(curList.size() - 1);
            }
            return;
        }
        curList.add(cur.val);
        curSum += cur.val;
        if (cur.left != null) sumDFS(cur.left, curSum, curList, sum);
        if (cur.right != null) sumDFS(cur.right, curSum, curList, sum);
        curList.remove(curList.size() - 1);
        curSum -= cur.val;
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
