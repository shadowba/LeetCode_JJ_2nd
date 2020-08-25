package com.LeetCodeJack2nd.Problems100;

public class P209_M_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        while (right < len) {
            while (right < len && sum < s) {
                sum += nums[right];
                right++;
            }
            while (sum >= s) {
                res = Math.min(res, (right - left));
                sum -= nums[left];
                left++;
            }
        }
        return (res==Integer.MAX_VALUE)?0:res;
    }
}
