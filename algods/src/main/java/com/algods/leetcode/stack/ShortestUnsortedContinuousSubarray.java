package com.algods.leetcode.stack;
/* 
 * 581. Shortest Unsorted Continuous Subarray
 * 
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 *  then the whole array will be sorted in ascending order.
 *  Return the shortest such subarray and output its length.
Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 */
import java.util.*;
public class ShortestUnsortedContinuousSubarray {
	/* Monotonic Stack */
	public int findUnsortedSubarray(int[] nums) {
		int start=nums.length -1, end=0;// default
		Deque<Integer> monoQue= new ArrayDeque<>();
		for(int i=0; i< nums.length; i++) {
			while(!monoQue.isEmpty() && nums[monoQue.peekLast()] > nums[i]) {
				start=Math.min(start, monoQue.pollLast());
//				end=Math.max(end, i); WONT DO for DUPLICATE ITEMS
			}
			monoQue.offerLast(i);
		}
		if(start == nums.length -1) return 0;// all are in order
		monoQue.clear();
		for(int i=nums.length -1; i>=0; i--) {
			while(!monoQue.isEmpty() && nums[monoQue.peekLast()]< nums[i]) {
				end=Math.max(end, monoQue.pollLast());
			}
			monoQue.offerLast(i);
		}
		return end-start+1;
	}
}
