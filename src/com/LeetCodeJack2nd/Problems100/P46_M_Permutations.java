package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P46_M_Permutations {
    List<List<Integer>> resList;
    int N;
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        resList = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return resList;
        N = nums.length;
        visited = new boolean[N];
        List<Integer> curList = new ArrayList<>();
        helper(nums, curList);
        return resList;
    }

    private void helper(int[] nums, List<Integer> curList) {
        if (curList.size() == N) {
            resList.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i]==true)
                continue;
            curList.add(nums[i]);
            visited[i]=true;
            helper(nums, curList);
            visited[i]=false;
            curList.remove(curList.size() - 1);
        }
    }
}
