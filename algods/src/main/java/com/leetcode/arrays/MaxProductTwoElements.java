package com.leetcode.arrays;
/* 1464. Maximum Product of Two Elements in an Array
 * 
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 

Example 1:

Input: nums = [3,4,5,2]
Output: 12 
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 
Example 2:

Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
Example 3:

Input: nums = [3,7]
Output: 12
 

Constraints:

2 <= nums.length <= 500
1 <= nums[i] <= 10^3
 * */
import java.util.Arrays;
public class MaxProductTwoElements {
	/* Approach 02: find top 2 elements */
	public int maxProduct(int[] nums) {
		int maxOne=0, maxTwo=0;
		for(int n: nums) {
			if(n> maxOne) {
				maxTwo=maxOne;
				maxOne=n;
			}else if(n> maxTwo) {
				maxTwo=n;
			}
		}
		return (maxOne-1)*(maxTwo-1);
	}
	/* Approach 01: sorting*/
//	public int maxProduct(int[] nums) {
//        Arrays.sort(nums);
//        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
//	}
}
