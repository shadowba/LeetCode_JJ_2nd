package com.LeetCodeJack2nd.Problems100;

import java.util.*;

public class P215_M_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        randomize(nums);
        int idx=0;
        int left=0;
        int N=nums.length;
        int right=N-1;
        while(left<=right){
            idx= partition(nums,left,right);
            if(idx==(N-k))
                return nums[idx];
            else if(N-k<idx){
                right=idx-1;
            }else
                left=idx+1;
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int fast = left;
        int slow = left-1;
        int pivot = nums[right];
        while (fast<right) {
            if(nums[fast]<pivot){
                swap(nums,slow+1,fast);
                slow++;
                fast++;
            }else
                fast++;
        }
        swap(nums,slow+1,right);
        return slow+1;
    }

    private void randomize(int[] nums) {
        Random rand = new Random();
        for (int i = nums.length - 1; i >= 0; i--){
            swap(nums,i,rand.nextInt(i+1));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//        - - -  Priority Queue Method / Heap Method  - - -
//    public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> pq= new PriorityQueue<>(k);
//        for(int num: nums){
//            pq.offer(num);
//            if(pq.size()>k)
//                pq.poll();
//        }
//        return pq.peek();
//    }


