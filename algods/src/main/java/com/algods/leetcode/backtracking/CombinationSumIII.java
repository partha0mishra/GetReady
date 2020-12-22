package com.algods.leetcode.backtracking;
// TODO Anki
/* *
 * Combination Sum III
 * 
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Note:
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
import java.util.*;
public class CombinationSumIII {
	/* Complexity calculations
	 * Time: if K= number of digits => O( 9!.K/ (9-k)!)
	 * Space: O(K)
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> ans = new ArrayList<>();
	    combination(ans, new ArrayList<Integer>(), k, 1, n);
	    return ans;
	}

	private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int remain) {
		if(remain<0) return;// no point going any further
	    if(comb.size() > k) return;// no point going any further
		if (comb.size() == k && remain == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(ans, comb, k, i+1, remain-i);
			comb.remove(comb.size() - 1);
		}
	}
	public static void main(String[] args) {
	}

}
