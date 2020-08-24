package com.LeetCodeJack2nd.Problems100;

public class P162_M_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        if(nums.length==1)
            return 0;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i=0;i<nums.length; i++){
            if(i==0)
                left = Integer.MIN_VALUE;
            else
                left = nums[i-1];

            if(i==nums.length-1)
                right = Integer.MIN_VALUE;
            else
                right = nums[i+1];
            if(left<nums[i] && nums[i]>right)
                return i;
        }
        return -1;
    }
}

//    public int findPeakElement(int[] nums) {
//        if(nums == null || nums.length == 0)
//            return -1;
//        if(nums.length==1)
//            return 0;
//        int left = Integer.MIN_VALUE;
//        int right = Integer.MIN_VALUE;
//        for(int i=0;i<nums.length; i++){
//            if(i==0)
//                left = Integer.MIN_VALUE;
//            else
//                left = nums[i-1];
//
//            if(i==nums.length-1)
//                right = Integer.MIN_VALUE;
//            else
//                right = nums[i+1];
//            if(left<nums[i] && nums[i]>right)
//                return i;
//        }
//        return -1;
//    }
