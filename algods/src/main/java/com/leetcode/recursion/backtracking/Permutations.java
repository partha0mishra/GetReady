package com.leetcode.recursion.backtracking;
// TODO Anki
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
	/* Backtracking - even better */
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        ArrayList<Integer> partial=new ArrayList<>();
        for(int n: nums) partial.add(n);
        backtrack(0, partial, result);// start, nums (combo), result
        return result;
    }
	private void backtrack(int start, ArrayList<Integer> partial, List<List<Integer>> result) {
		if(start == partial.size() -1) {
			result.add(new ArrayList<>(partial));// remember to copy
			return;
		}
		for(int i=start; i< partial.size(); i++) {
			Collections.swap(partial, i, start);// swap
			backtrack(start+1,partial,result);
			Collections.swap(partial, i, start);// swap it back
		}
	}
	/* Revisiting backtracking 
	 * O(T) = 1+n+n(n-1)+n(n-1)(n-2)...+n! = O(n . n!) 
	 * O(M) = O(n!) */
//	public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result=new ArrayList<List<Integer>>();
//        backtrack(nums, result, new ArrayList<Integer>());// nums, result, partial
//        return result;
//    }
//	private void backtrack(int[] nums,List<List<Integer>> result, ArrayList<Integer> partial) {
//		if(partial.size() == nums.length) {
//			result.add(new ArrayList<Integer>(partial));// remember to copy
//			return;
//		}
//		for(int i=0; i< nums.length; i++) {
//			if(partial.contains(nums[i])) continue;
//			partial.add(nums[i]);
//			backtrack(nums, result, partial);
//			partial.remove(partial.size()-1);
//		}
//	}
	/* Earlier backtracking - perfectly working code */
//	public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result=new ArrayList<List<Integer>>();
//        Arrays.sort(nums);
//        backtrack(nums, result, new ArrayList<Integer>(), 0);
//        return result;
//    }
//	private void backtrack(int[] nums,List<List<Integer>> result, ArrayList<Integer> temp, int start) {
//		if(temp.size() == nums.length) {
//			result.add(new ArrayList<Integer>(temp));
//			return;
//		}
//		for(int i=0; i< nums.length; i++) {
//			if(temp.contains(nums[i])) continue;
//			temp.add(nums[i]);
//			backtrack(nums, result, temp, i);
//			temp.remove(temp.size()-1);
//		}
//	}
	public static void main(String[] args) {
		System.out.println(new Permutations().permute(new int[] {1,2,3}));
	}

}
