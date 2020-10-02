package com.algods.leetcode.backtracking;
/* 90. Subsets II
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * */
import java.util.*;
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }
	private void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> temp, int start) {
		result.add(new ArrayList<Integer>(temp));
		for(int i=start; i< nums.length; i++) {
			if(i > start && nums[i] == nums[i-1]) continue;
			temp.add(nums[i]);
			backtrack(nums, result, temp, i+1);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(new SubsetsII().subsetsWithDup(new int[] {1,2,2,3}));
	}

}
