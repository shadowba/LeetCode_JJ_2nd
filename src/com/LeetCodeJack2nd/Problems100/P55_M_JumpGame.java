package com.LeetCodeJack2nd.Problems100;

import java.util.Arrays;

public class P55_M_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int N = nums.length;

        int[] step = new int[N];

        for (int i = 1; i < N; i++) {
            step[i] = Math.max(nums[i-1], step[i-1])-1;
            if(step[i]<0)
                return false;
        }
        return true;
    }
}
