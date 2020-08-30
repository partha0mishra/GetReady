package com.algods.leetcode;

public class MaxSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
    	int maxLen=0;
    	for(int len=1; len<= nums.length; len++) {
    		for(int start=0; start<= nums.length-len; start++) {
    			if(positive(nums,start,len)) {
    				maxLen=len;
    				break;
    			}
    		}
    	}
    	
    	return maxLen;
    }
    private boolean positive(int[] nums, int start, int len) {
    	int negativeCount=0;
    	for(int i=0;i<len; i++) {
    		int num=nums[start+i];
    		if(num ==0) return false;// 0 is not positive
    		if(num < 0) negativeCount++;
    	}
    	return negativeCount %2 ==0;
    }
	public static void main(String[] args) {
		MaxSubarrayWithPositiveProduct instance= new MaxSubarrayWithPositiveProduct();
		System.out.println(instance.getMaxLen(new int[] {-1,-1}));
	}

}
