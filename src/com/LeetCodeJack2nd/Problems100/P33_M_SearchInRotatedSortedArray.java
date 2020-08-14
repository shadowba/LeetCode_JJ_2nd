package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P33_M_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        if (target == nums[n - 1])
            return n - 1;
        int rotateIdx = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[rotateIdx])
                break;
            rotateIdx--;
        }
        int left = 0;
        int right = n - 1;
        int mid = 0;

        if (target > nums[n - 1])
            right = rotateIdx - 1;
        else
            left = rotateIdx;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0)
//            return -1;
//        int n = nums.length;
//        if (target == nums[n - 1])
//            return n - 1;
//        int rotateIdx = n - 1;
//        for (int i = n - 2; i >= 0; i--) {
//            if (nums[i] > nums[rotateIdx])
//                break;
//            rotateIdx--;
//        }
//        int left = 0;
//        int right = n - 1;
//        int mid = 0;
//
//        if (target > nums[n - 1])
//            right = rotateIdx - 1;
//        else
//            left = rotateIdx;
//
//        while (left <= right) {
//            mid = (left + right) / 2;
//            if (nums[mid] == target)
//                return mid;
//            else if (target < nums[mid])
//                right = mid - 1;
//            else
//                left = mid + 1;
//        }
//        return -1;
//    }
