package com.leetcode.binarySearch;
/* 644. Maximum Average Subarray II
 * You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is greater than or equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation:
- When the length is 4, averages are [0.5, 12.75, 10.5] and the maximum average is 12.75
- When the length is 5, averages are [10.4, 10.8] and the maximum average is 10.8
- When the length is 6, averages are [9.16667] and the maximum average is 9.16667
The maximum average is when we choose a subarray of length 4 (i.e., the sub array [12, -5, -6, 50]) which has the max average 12.75, so we return 12.75
Note that we do not consider the subarrays of length < 4.
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 

Constraints:

n == nums.length
1 <= k <= n <= 104
-104 <= nums[i] <= 104
 */
public class MaxAvgSubarray2 {
	/* Approach : Binary Search
	 * Theory:
	 * (nums[i]+nums[i+1]+...+nums[j])/(j-i+1)>x
	 * =>nums[i]+nums[i+1]+...+nums[j]>x*(j-i+1)
	 * =>(nums[i]-x)+(nums[i+1]-x)+...+(nums[j]-x)>0
	 * 
	 * 
	 */
	public double findMaxAverage(int[] nums, int k) {
		double left=-10001, right=10001;
		while(left+0.00001 < right) {
			double mid=left+(right-left)/2;
			if(foundAvg(nums,k,mid)) left=mid;
			else right=mid;
		}
		return left;
    }

	private boolean foundAvg(int[] nums, int k, double avg) {
		int n=nums.length;
		double[] newNums=new double[n];// keeping values of nums[i] -avg
		for(int i=0; i< n; i++) {newNums[i]=nums[i] - avg;}
		
		double curSum=0, prevSum=0;
		for(int i=0; i< k; i++) {curSum+=newNums[i];}// Just like the sliding window, from hereafter
		if(curSum > 0) return true;// found already
		// curSum keeps sum, increasingly
		// prevSum keeps sum of the elements in the front
		// if prevSum is negative, then removing that from curSum gives more probability of a curSum being >= 0
		for(int i=k; i< n; i++) {
			curSum+= newNums[i];
			prevSum+= newNums[i-k];
			if(prevSum < 0) {curSum-=prevSum; prevSum=0;}
			if(curSum >= 0) return true;
		}
		return false;
	}
}
