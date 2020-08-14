package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P40_M_CombinationSum2 {
    List<List<Integer>> resList;
    int Target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        resList = new ArrayList<>();
        this.Target = target;
        if(candidates==null || candidates.length == 0)
            return resList;
        Arrays.sort(candidates);
        List<Integer> curList= new ArrayList<>();
        helper(candidates,curList, 0,0);
        return resList;
    }
    private void helper(int[] nums, List<Integer> curList, int start, int sum){
        if(sum>=Target){
            if(sum==Target)
                resList.add(new ArrayList<>(curList));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1])
                continue;
            curList.add(nums[i]);
            helper(nums,curList,i+1,sum+nums[i]);
            curList.remove(curList.size()-1);
        }
    }
}
