package com.algods.leetcode.backtracking;
/* 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * You may return the answer in any order.
 * Example 1:
 * Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:
Input: n = 1, k = 1
Output: [[1]]
Constraints:
1 <= n <= 20
1 <= k <= n
 */
import java.util.*;
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result= new ArrayList<>();
		for(int i=0; i< n; i++) {
			result.add(combine(i, n-1,k-1));
		}
		return result;
    }
	
	private List<Integer> combine(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
