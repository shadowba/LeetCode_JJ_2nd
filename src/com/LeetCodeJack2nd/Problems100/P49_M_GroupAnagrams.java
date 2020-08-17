package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P49_M_GroupAnagrams {
    Map<String, List<String>> dic;
    List<List<String>> resList;
    public List<List<String>> groupAnagrams(String[] strs) {
        dic = new HashMap<>();
        resList = new ArrayList<>();
        if(strs == null || strs.length==0)
            return resList;
        char[] chArr;
        for(String str: strs){
            chArr = str.toCharArray();
            Arrays.sort(chArr);
            if(dic.containsKey(String.valueOf(chArr)))
                dic.get(String.valueOf(chArr)).add(str);
            else{
                dic.put(String.valueOf(chArr), new ArrayList<>());
                dic.get(String.valueOf(chArr)).add(str);;
            }
        }
        for(String s :dic.keySet())
            resList.add(new ArrayList<>(dic.get(s)));

        return resList;
    }
}
