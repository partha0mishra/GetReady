package com.algods.leetcode.arrays;
/* 643. Maximum Average Subarray I
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 

Note:

1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaxAvgSubarray1 {
	/* Approach 01: Brute force O(n)*/
	public double findMaxAverage(int[] nums, int k) {
        long sum=0;
        for(int i=0; i< k; i++) sum+=nums[i];
        double result=(double)sum/k;
        for(int i=k,j=0; i< nums.length;i++,j++) {
        	sum-=nums[j];
        	sum+=nums[i];
        	double avg=(double)sum/k;
        	if(avg > result) result=avg;
        }
        return result;
    }
}
