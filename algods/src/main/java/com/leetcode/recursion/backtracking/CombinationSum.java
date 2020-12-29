package com.leetcode.recursion.backtracking;
// TODO Anki
/* Combination Sum
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen numbers sum to target. 
 * You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.


Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
 * */
import java.util.*;
public class CombinationSum {
	/* Approach 02: Backtracking as a template */
	/* complexity analysis
	 * this is a recursion with n-ary tree.
	 * depth of the tree = Target/ Minimum number <= worst case scenario
	 * O(N^(T/M)+1) Time complexity
	 * O(T/M) Space Complexity for recursion stack of all those levels
	 */
	public List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	/* Approach 01: backtracking by Me*/
//	List<List<Integer>> result;
//	public List<List<Integer>> combinationSum(int[] candidates, int target) {
//		result= new ArrayList<List<Integer>>();
//		Arrays.sort(candidates);
//		findSum(candidates,new ArrayList<Integer>(),target,0,0);
//		return result;
//    }
//	private void findSum(int[] candidates, ArrayList<Integer> temp, int target,
//			int tempSum, int start) {
//		if(tempSum > target) return;// not working
//		if(tempSum == target) {result.add(new ArrayList<Integer>(temp)); return;}
//		for(int i=start; i< candidates.length; i++) {
//			temp.add(candidates[i]);
//			findSum(candidates,temp,target,tempSum+candidates[i],i);
//			temp.remove(temp.size()-1);
//		}
//	}
	

	public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7));
//		System.out.println(new CombinationSum().combinationSum(new int[] {2,3,5}, 8));
//		System.out.println(new CombinationSum().combinationSum(new int[] {2}, 1));
//		System.out.println(new CombinationSum().combinationSum(new int[] {1}, 1));
//		System.out.println(new CombinationSum().combinationSum(new int[] {1}, 2));
	}

}
