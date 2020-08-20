package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P89_M_GrayCode {
    List<Integer> resList;
    public List<Integer> grayCode(int n) {
        resList = new ArrayList<>();
        resList.add(0);
        if(n==0)
            return resList;
        for(int i=1; i<(1<<n); i++){
            resList.add(i^(i>>1));
        }
        return resList;
    }
}
