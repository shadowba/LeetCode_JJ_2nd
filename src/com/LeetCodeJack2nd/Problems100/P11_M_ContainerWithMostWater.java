package com.LeetCodeJack2nd.Problems100;

public class P11_M_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length <=1)
            return 0;

        int area=0;
        int res=0;
        int N = height.length;
        for(int i=0; i<N-1;i++){
            for(int j=i+1; j<N; j++){
                area = Math.min(height[i],height[j])*(j-i);
                res = Math.max(area,res);
            }
        }
        return res;
    }
}
