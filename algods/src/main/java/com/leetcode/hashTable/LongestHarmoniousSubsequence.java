package com.leetcode.hashTable;
/**
 * 594. Longest Harmonious Subsequence
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Example 2:

Input: nums = [1,2,3,4]
Output: 2
Example 3:

Input: nums = [1,1,1,1]
Output: 0
 

Constraints:

1 <= nums.length <= 2 * 104
-109 <= nums[i] <= 109
 */
import java.util.*;
public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		int max=0;
		HashMap<Integer, Integer> counts= new HashMap<>();
		for(int n: nums) counts.put(n, counts.getOrDefault(n,0)+1);
		for(int n: counts.keySet()) {
			int eq=counts.get(n);
			int prev=counts.getOrDefault(n-1, 0);
			int next=counts.getOrDefault(n+1, 0);
			if(prev > 0) prev+=eq;
			if(next > 0) next+=eq;
			eq=Math.max(prev, next);
			if(eq > max) max=eq;
		}
		return max;
    }
	public static void main(String[] a) {
		LongestHarmoniousSubsequence lhs= new LongestHarmoniousSubsequence();
		System.out.println(lhs.findLHS(new int[] {1,3,2,2,5,2,3,7}));//5
		System.out.println(lhs.findLHS(new int[] {1,2,3,4}));//2
		System.out.println(lhs.findLHS(new int[] {1,1,1,1}));//0
		System.out.println(lhs.findLHS(new int[] {1,2,2,1}));//4
		System.out.println(lhs.findLHS(new int[] {-1,0,-1,0,-1,0,-1}));//7
	}
}
