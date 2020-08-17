package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P56_M_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals==null|| intervals.length==0)
            return intervals;

        Collections.sort(Arrays.asList(intervals), new intervalComparator());

        LinkedList<int[]> mergedRes = new LinkedList<>();
        for(int[] interval: intervals){
            if(mergedRes.isEmpty()||mergedRes.getLast()[1]<interval[0])
                mergedRes.add(interval);
            else{
                mergedRes.getLast()[1] = Math.max(mergedRes.getLast()[1], interval[1]);
            }
        }
        return mergedRes.toArray(new int[mergedRes.size()][2]);
    }

    private class intervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
