package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P78_M_Subsets {
    List<List<Integer>> resList;

    public List<List<Integer>> subsets(int[] nums) {
        resList = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return resList;
        List<Integer> curList = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            helper(nums, i, 0, curList);
        }
        return resList;
    }

    private void helper(int[] nums, int size, int start, List<Integer> curList) {
        if (curList.size() == size) {
            resList.add(new ArrayList<>(curList));
            return;
        }
        for (int j = start; j < nums.length; j++) {
            curList.add(nums[j]);
            helper(nums, size, j + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
