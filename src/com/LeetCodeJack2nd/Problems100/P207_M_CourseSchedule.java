package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P207_M_CourseSchedule {
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length==0)
            return false;
        for(int[] combo:prerequisites){
            if(!map.containsKey(combo[1]))
                map.put(combo[1], new ArrayList<Integer>());
            map.get(combo[1]).add(combo[0]);
        }
        int[] visit = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(!finishDFS(i,visit))
                return false;
        }
        return true;
    }

    private boolean finishDFS(int course, int[] visit){
        if(visit[course]==-1)
            return false;
        if(visit[course]==1)
            return true;

        visit[course] = -1;
        if(map.containsKey(course)){
            for(int preCourse:map.get(course)){
                if(!finishDFS(preCourse,visit))
                    return false;
            }
        }
        visit[course] = 1;
        return true;
    }
}
