package com.algods.leetcode.backtracking;
/* 47. Permutations II
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * */
import java.util.*;
public class Permutations2 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums,result,new ArrayList<Integer>(),new boolean[nums.length]);
        return result;
    }
	private void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> temp, boolean[] used) {
		if(temp.size() == nums.length) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=0; i< nums.length; i++) {
			if(used[i] ||
					i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
			used[i]=true;
			temp.add(nums[i]);
			backtrack(nums, result, temp, used);
			used[i]=false;
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(new Permutations2().permuteUnique(new int[] {1,1,2}));
	}
}
