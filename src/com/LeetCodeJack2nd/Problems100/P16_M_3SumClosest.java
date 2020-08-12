package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P16_M_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null | nums.length == 0)
            return 0;

        int N = nums.length;
        int diff = Integer.MAX_VALUE;
        int newDiff = 0;
        int sum = 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                newDiff = Math.abs(target - sum);
                if (newDiff < diff) {
                    res = sum;
                    diff = newDiff;
                }

                if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        return res;
    }
}
