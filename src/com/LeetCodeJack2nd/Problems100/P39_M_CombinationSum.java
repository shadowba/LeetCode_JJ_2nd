package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P39_M_CombinationSum {
    List<List<Integer>> resList;
    int Target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        resList = new ArrayList<>();
        this.Target = target;
        if (candidates == null || candidates.length == 0)
            return resList;
        Arrays.sort(candidates);
        List<Integer> curList = new ArrayList<>();
        helper(candidates, 0, curList, 0);
        return resList;
    }

    private void helper(int[] nums, int start, List<Integer> curList, int sum) {
        if (sum >= Target) {
            if (sum == Target)
                resList.add(new ArrayList<Integer>(curList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            helper(nums, i, curList, sum + nums[i]);
            curList.remove(curList.size() - 1);
        }
    }
}
