package com.LeetCodeJack2nd.Problems100;

public class P96_M_UniqueBinarySearchTrees {
//    卡塔兰数
//    https://www.cnblogs.com/grandyang/p/4299608.html

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] =1;
        if(n<=1)
            return dp[1];
        for(int i=2; i<=n;i++){
            for(int j = 0; j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
