package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P18_M_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length <= 3)
            return resList;

        int N = nums.length;
        Arrays.sort(nums);
        int sum;
        for (int i = 0; i < N - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            if (nums[i] > target)
//                break;
            for (int j = i + 1; j < N - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
//                if (nums[i] + nums[j] > target)
//                    break;
                int left = j + 1;
                int right = N - 1;
                while (left < right) {
                    sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (target == sum) {
                        resList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return resList;
    }
}
