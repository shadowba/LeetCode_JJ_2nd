package com.LeetCodeJack2nd.Problems100;

public class P213_M_HouseRobber2 {
    public int rob(int[] nums) {
        if(nums==null ||nums.length <=1){
            if(nums.length == 1)
                return nums[0];
            else
                return 0;
        }
        int right = nums.length-1;
        return Math.max(robbery(nums,0,right-1), robbery(nums, 1,right));
    }
    private int robbery(int[] nums, int left, int right){
        int length = right-left+2;
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = nums[left];
        for(int i =2; i<length; i++){
            dp[i] = Math.max(dp[i-2]+nums[left+i-1],dp[i-1]);
        }
        return dp[length-1];
    }
}
