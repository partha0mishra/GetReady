package com.algods.leetcode.explore.september;

import java.util.Arrays;

/* First Missing Positive
 * 
 * Given an unsorted integer array, find the smallest missing positive integer.
Example 1:
Input: [1,2,0]
Output: 3
Example 2:
Input: [3,4,-1,1]
Output: 2
Example 3:
Input: [7,8,9,11,12]
Output: 1
Follow up:

Your algorithm should run in O(n) time and uses constant extra space.
 * */
public class FindMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if(nums.length < 1) return 1;
		Arrays.sort(nums);
		if(nums[nums.length-1] < 1) return 1;
		int i, n=1;
		for(i=0; i< nums.length; i++) {
			if(nums[i] <1) continue;
			if(nums[i] == n) n++;
			else if(nums[i] == n-1) continue;// duplicate
			else break;
		}
		return n;
    }
}
