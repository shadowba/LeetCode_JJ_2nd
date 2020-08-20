package com.LeetCodeJack2nd.Problems100;

public class P91_M_DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if(s.charAt(0)-'0'==0)
            return 0;
        dp[0] = 1;
        int num=0;
        for(int i=1; i<dp.length; i++){
            dp[i] = (s.charAt(i-1)=='0')?0:dp[i-1];
            if(i>=2){
                num = (s.charAt(i-1)-'0')+(s.charAt(i-2)-'0')*10;
                if(num>=10&&num<=26)
                    dp[i]+=dp[i-2];
            }

        }
        return dp[dp.length-1];
    }
}
