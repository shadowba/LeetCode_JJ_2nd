package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P139_M_WordBreak {
    Set<String> dic;
    Map<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        dic = new HashSet<>(wordDict);
        map = new HashMap<>();
        return helper(s);
    }
    private boolean helper(String sub){
        if(map.containsKey(sub))
            return map.get(sub);

        if(dic.contains(sub)){
            map.put(sub,true);
            return true;
        }

        for(int i = 1; i<sub.length(); i++){
            String left = sub.substring(0,i);
            String right = sub.substring(i,sub.length());
            if(dic.contains(left)&&helper(right)){
                map.put(left,true);
                return true;
            }
        }
        map.put(sub,false);
        return false;
    }
}
