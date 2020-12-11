package com.algods.leetcode.stack;
/* Target Sum
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 

Constraints:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
import java.util.*;
public class TargetSum {

	/* Memoization for a sum at an index. Significantly faster 
	 * O(<Range of Sum> * <Length of Array>) / O(L*N)*/
	HashMap<Integer,Integer> memo;
	public int findTargetSumWays(int[] nums, int S) {
		memo=new HashMap<>();
        return findWays(nums,0,0,S);// int[], position, sum-so-far, targetSum
    }
	private int findWays(int[] n, int pos, int sum, int target) {
		if(pos == n.length) return (sum == target)? 1:0;
		if(!memo.containsKey(sum*1000+pos)) {
			memo.put(sum*1000+pos, findWays(n, pos+1, sum+n[pos], target)+ findWays(n, pos+1, sum-n[pos], target));
		}
		return memo.get(sum*1000+pos);
	}
	/* Recursion + Backtracking: O(2^n) O(n) recursion stack */
//	public int findTargetSumWays(int[] nums, int S) {
//        return findWays(nums,0,0,S);// int[], position, sum-so-far, targetSum
//    }
//	private int findWays(int[] n, int pos, int sum, int target) {
//		if(pos == n.length) return (sum == target)? 1:0;
//		
//		return findWays(n, pos+1, sum+n[pos], target)+ findWays(n, pos+1, sum-n[pos], target);
//	}
	public static void main(String[] args) {
		System.out.println(new TargetSum().findTargetSumWays(new int[] {1,1,1,1,1}, 3));
		System.out.println(new TargetSum().findTargetSumWays(new int[] 
				{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30}, 3));
		System.out.println(new TargetSum().findTargetSumWays(new int[] 
				{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 3));
	}
}
