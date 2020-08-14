package com.LeetCodeJack2nd.Problems100;
import java.util.*;
public class P34_M_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0)
            return res;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (nums[right] == target) res[0] = right;
        else
            return res;
        if (nums[n - 1] == target) {
            res[1] = n - 1;
            return res;
        }
        left = res[0];
        right = n - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else right = mid;
        }
        res[1] = (left - 1 < 0) ? 0 : left - 1;
        return res;
    }
}
