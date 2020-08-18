package com.LeetCodeJack2nd.Problems100;

public class P81_M_SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int n = nums.length;
        int left, mid, right;
        left = 0;
        right = n - 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid]<nums[right]){
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else if(nums[mid]>nums[right]){
                if(nums[left]<=target && nums[mid]>target) right =mid-1;
                else left = mid+1;
            }else
                right--;

        }
        return false;
    }
}

// 1ms - - 51.70% || 39.1 MB - - 87.05%
//    public boolean search(int[] nums, int target) {
//        if(nums==null||nums.length==0)
//            return false;
//        int n=nums.length;
//        int partIdx=0;
//        for(int i=0; i<n-1;i++){
//            if(nums[i]==target)
//                return true;
//            if(nums[i+1]<nums[i]){
//                partIdx = i+1;
//                break;
//            }
//        }
//        int left,mid,right;
//        left=0;
//        right = n-1;
//        if(target >= nums[partIdx]){
//            if(nums[partIdx]==target)
//                return true;
//            left=partIdx;
//        }else{
//            right = (partIdx-1>=0)?partIdx-1:0;
//        }
//        while(left<=right){
//            mid=(left+right)/2;
//            if(target==nums[mid])
//                return true;
//            else if(target<nums[mid])
//                right=mid-1;
//            else
//                left=mid+1;
//        }
//        return false;
//    }
