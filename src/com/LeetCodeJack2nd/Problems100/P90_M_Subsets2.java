package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P90_M_Subsets2 {
    List<List<Integer>> resList;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        resList = new ArrayList<>();
        if(nums== null || nums.length == 0)
            return resList;
        Arrays.sort(nums);
        List<Integer> curList = new ArrayList<>();
        helper(nums,0,0,curList);
        return resList;
    }
    private void helper(int[] nums, int start, int size, List<Integer> curList){
        if(curList.size() == size){
            resList.add(new ArrayList<>(curList));
        }
        int i=start;
        while(i<nums.length){
            curList.add(nums[i]);
            helper(nums, i+1, size+1, curList);
            while(i+1<nums.length && nums[i]==nums[i+1])
                i++;
            curList.remove(curList.size()-1);
            i++;
        }
    }
}
