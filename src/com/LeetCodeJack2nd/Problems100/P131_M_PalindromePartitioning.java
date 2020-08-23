package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P131_M_PalindromePartitioning {
    List<List<String>> resList;
    public List<List<String>> partition(String s) {
        resList = new ArrayList<>();
        if(s.length()==0)
            return resList;
        List<String> curList = new ArrayList<>();
        helper(s,curList);
        return resList;
    }

    private void helper(String s, List<String> curList){
        if(s.equals("")){
            resList.add(new ArrayList<>(curList));
            return;
        }
        for(int i =1;i<=s.length();i++){
            if(isValid(s.substring(0,i))){
                curList.add(s.substring(0,i));
                helper(s.substring(i),curList);
                curList.remove(curList.size()-1);
            }
        }
    }

    private boolean isValid(String s){
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;

//        if(s.length()==1)
//            return true;
//        StringBuilder sb = new StringBuilder();
//        sb.append(s);
//        return (sb.reverse().toString().equals(s));
    }
}
