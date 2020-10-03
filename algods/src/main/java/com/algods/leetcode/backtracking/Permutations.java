package com.algods.leetcode.backtracking;
/* 46. Permutations
 * 
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * */
import java.util.*;
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }
	private void backtrack(int[] nums,List<List<Integer>> result, ArrayList<Integer> temp, int start) {
		if(temp.size() == nums.length) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=0; i< nums.length; i++) {
			if(temp.contains(nums[i])) continue;
			temp.add(nums[i]);
			backtrack(nums, result, temp, i);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(new Permutations().permute(new int[] {1,2,3}));
	}

}
