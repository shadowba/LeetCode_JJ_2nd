package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P47_M_Permutations2 {
    List<List<Integer>> resList;
    int N;
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        resList = new ArrayList<>();
        if(nums == null || nums.length ==0)
            return resList;
        N = nums.length;
        visited = new boolean[N];
        Arrays.sort(nums);
        List<Integer> curList = new ArrayList<>();
        helper(nums, curList);
        return resList;
    }
    private void helper(int[] nums, List<Integer> curList){
        if(curList.size()==N)
            resList.add(new ArrayList<>(curList));

        for(int i=0; i<N;i++){
            if(visited[i] == true )
                continue;
            if(i>0&& nums[i]==nums[i-1]&&visited[i-1]==false)
                continue;
            visited[i]=true;
            curList.add(nums[i]);
            helper(nums,curList);
            curList.remove(curList.size()-1);
            visited[i]=false;
        }
    }
}
