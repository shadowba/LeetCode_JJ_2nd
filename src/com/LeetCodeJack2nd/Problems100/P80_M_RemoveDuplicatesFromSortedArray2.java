package com.LeetCodeJack2nd.Problems100;

public class P80_M_RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int N=nums.length;
        if(N<3)
            return N;

        int slow = 2;

        for(int i = 2; i<N;i++){
            if(nums[slow-1]!=nums[i]|| nums[slow-2]!=nums[i]){
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }
}
