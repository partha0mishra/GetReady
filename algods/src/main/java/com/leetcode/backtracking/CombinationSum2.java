package com.leetcode.backtracking;
// TODO Anki
/* 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 * */
import java.util.*;
public class CombinationSum2 {
	// O(2^N) - for each number, 2 choices - pick it or not
	// space complexity O(N)
	//
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0/*tempsum*/,0/*start*/,new ArrayList<Integer>()/*temp*/, result);
        return result;
    }

	private void backtrack(int[] nums, int target, int tempSum, int start, ArrayList<Integer> temp, List<List<Integer>> result) {
		if(tempSum > target) return; //Dead-end
		else if(tempSum == target) result.add(new ArrayList<Integer>(temp));
		else {
			for(int i=start; i< nums.length; i++) {
				if(i> start && nums[i]==nums[i-1]) continue;
				temp.add(nums[i]);
				backtrack(nums, target, tempSum+nums[i], i+1, temp, result);
				temp.remove(temp.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new CombinationSum2().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
	}
}
