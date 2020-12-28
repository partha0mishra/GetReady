package com.leetcode.backtracking;
// TODO Anki
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
		combine(result, new ArrayList<Integer>(), n, k, 1);
		return result;
    }
	private void combine(List<List<Integer>> result, ArrayList<Integer> partial, int n, int k, int start) {
		if(partial.size() == k) result.add(new ArrayList<>(partial));
		else {
			for(int i=start; i<= n; i++) {// no reuse of digit like [1,2] and [2,1]
				partial.add(i);
				combine(result, partial, n, k, i+1);// no repeat
				partial.remove(partial.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		Combinations c= new Combinations();
		System.out.println(c.combine(4, 2));
		System.out.println(c.combine(1,1));
	}

}
