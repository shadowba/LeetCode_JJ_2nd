package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P15_M_3Sum {
    List<List<Integer>> resList;

    public List<List<Integer>> threeSum(int[] nums) {
        resList = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return resList;
        int N = nums.length;
        List<Integer> curList = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < N - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            target = 0 - nums[i];
            left = i + 1;
            right = N - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    curList.add(nums[i]);
                    curList.add(nums[left]);
                    curList.add(nums[right]);
                    resList.add(new ArrayList(curList));
                    curList.clear();
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return resList;
    }
}
