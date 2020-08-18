package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P77_M_Combinations {
    List<List<Integer>> resList;
    public List<List<Integer>> combine(int n, int k) {
        resList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        helper(1,n,k, curList);
        return resList;
    }
    private void helper(int start, int n, int k, List<Integer> curList){
        if(curList.size()==k){
            resList.add(new ArrayList<>(curList));
            return;
        }

        for(int i=start; i<= n; i++){
            curList.add(i);
            helper(i+1,n,k,curList);
            curList.remove(curList.size()-1);
        }
    }
}
