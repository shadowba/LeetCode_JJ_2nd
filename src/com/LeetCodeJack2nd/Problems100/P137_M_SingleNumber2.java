package com.LeetCodeJack2nd.Problems100;

public class P137_M_SingleNumber2 {
    public int singleNumber(int[] nums) {
        int sum = 0;
        int res = 0;
        for(int i=0; i<32; i++){
            sum=0;
            for(int j=0; j<nums.length; j++){
                sum += (nums[j]>>i)&1;
            }
            res+=(sum%3)<<i;
        }
        return res;
    }
}
