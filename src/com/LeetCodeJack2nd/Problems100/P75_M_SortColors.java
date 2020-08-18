package com.LeetCodeJack2nd.Problems100;

public class P75_M_SortColors {
    public void sortColors(int[] nums) {
        if(nums==null|| nums.length==0)
            return;
        int n = nums.length;
        int slow=0;
        int fast= n-1;
        int cnt=0;
        for(int i=0;i<=fast;i++){
            if(nums[i]==0)
                swap(nums,i,slow++);
            else if(nums[i]==2)
                swap(nums,i--,fast--);
            else
                cnt++;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }
}
