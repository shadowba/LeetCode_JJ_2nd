package com.LeetCodeJack2nd.Problems100;

public class P134_M_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] tank;
        int start = 0;
        int idx = 0;
        int prev = 0;
        int n = gas.length;
        boolean flag = false;
        for (start = 0; start < n; start++) {
            tank = new int[n];
            tank[start] = gas[start];
            flag = false;
            for (int i = 1; i < n; i++) {
                prev = (start + i - 1 > n - 1) ? (start + i - n - 1) : (start + i - 1);
                idx = (start + i > n - 1) ? (start + i - n) : (start + i);

                if(tank[prev]-cost[prev]<0){
                    flag = true;
                    break;
                }
                tank[idx] = tank[prev] - cost[prev] + gas[idx];
            }
            if(flag == true)
                continue;
            if (tank[idx]>0&&tank[idx]-cost[idx] >= 0)
                return start;
        }
        return -1;
    }
}
