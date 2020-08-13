package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P31_M_NextPermutation {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int idx = -1;
        for (int i = N - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            Arrays.sort(nums);
            return;
        }
        int largerIdx = -1;
        for (int i = N - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                largerIdx = i;
                break;
            }
        }
        int temp = nums[largerIdx];
        nums[largerIdx] = nums[idx];
        nums[idx] = temp;
        Arrays.sort(nums, idx + 1, N);
    }
}
