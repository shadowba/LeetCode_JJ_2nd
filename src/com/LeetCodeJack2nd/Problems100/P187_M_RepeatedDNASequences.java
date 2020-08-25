package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P187_M_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        String sub;
        Set<String> set = new HashSet<>();
        Set<String> resset = new HashSet<>();
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        for (int i = 0; i < s.length() - 9; i++) {
            sub = s.substring(i, i + 10);
            if (set.contains(sub) && !resset.contains(sub)) {
                res.add(sub);
                resset.add(sub);
            } else
                set.add(sub);
        }
        return res;
    }
}
