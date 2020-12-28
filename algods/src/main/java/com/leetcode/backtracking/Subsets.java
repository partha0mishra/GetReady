package com.leetcode.backtracking;
// TODO Anki
/* 78. Subsets
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * */
import java.util.*;
public class Subsets {
	/* Backtracking
	 * O(N*2^N)/ O(N*2^N)
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result= new ArrayList<List<Integer>>();
		Arrays.sort(nums);// first, sort
		backtrack(nums,result,new ArrayList<Integer>(), 0);
		return result;
    }
	private void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> temp, int start) {
		result.add(new ArrayList<Integer>(temp));
		for(int i=start; i< nums.length; i++) {
			temp.add(nums[i]);
			backtrack(nums,result,temp,i+1);
			temp.remove(temp.size() -1);
		}
	}
	public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[] {1,2,3}));
	}
}
