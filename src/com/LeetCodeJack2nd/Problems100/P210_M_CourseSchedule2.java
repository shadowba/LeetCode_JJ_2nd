package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P210_M_CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        if (prerequisites == null || numCourses == 0)
            return res;

        for (int[] combo : prerequisites) {
            inDegree[combo[0]]++;
            if (!map.containsKey(combo[1]))
                map.put(combo[1], new ArrayList<>());
            map.get(combo[1]).add(combo[0]);
        }

        int first = 0, last = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                res[last]=i;
                last++;
            }
        }
        while(first<last){
            List<Integer> subCourses = map.get(res[first]);
            if(subCourses!=null){
                for(int sub:subCourses){
                    inDegree[sub]--;
                    if(inDegree[sub]==0){
                        res[last] = sub;
                        last++;
                    }
                }
            }
            first++;
        }
        if(last != numCourses) return new int[0];
        return res;
    }
}
