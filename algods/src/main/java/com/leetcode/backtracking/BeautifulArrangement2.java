package com.leetcode.backtracking;
/**
 * 667. Beautiful Arrangement 2
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

If there are multiple answers, print any of them.

Example 1:
Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
Example 2:
Input: n = 3, k = 2
Output: [1, 3, 2]
Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
Note:
The n and k are in the range 1 <= k < n <= 104.
 */
import java.util.*;
public class BeautifulArrangement2 {
	/**
	 * Approach 02: Construction :O
	 * O(n) O(n)
	 * Choose one from top and one from bottom for K times
	 * Fill in the rest ascending order 
	 */
	public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int c = 0;
        for (int v = 1; v < n-k; v++) {
            ans[c++] = v;
        }
        for (int i = 0; i <= k; i++) {
            ans[c++] = (i%2 == 0) ? (n-k + i/2) : (n - i/2);
        }
        return ans;
    }
	/**
	 * Approach 01: Backtracking - TLE
	 */
//	boolean solved=false;
//	public int[] constructArray(int n, int k) {
//		solved=false;
//        int[] result= new int[n];
//        backtrack(n, k, result, 0, new HashSet<Integer>(), new HashSet<Integer>());// n, k, result, index, used, usedDiff
//        return result;
//    }
//	private void backtrack(int n, int k, int[] result, int index, HashSet<Integer> used, HashSet<Integer> usedDiff) {
//		if(index == n && usedDiff.size()==k) {// EXACTLY K diffs
//			solved=true;
//			return;
//		}
//		
//		for(int num=1; num<=n; num++) {
//			int diff=0; 
//			boolean diffAdded=false;// track if this diff was carried from earlier or just added here
//			if(!solved // short circuit to stop solving once solved
//					&& !used.contains(num)) {// number not used yet
//				if(index > 0) {// prune based on explicit condition
//					diff=Math.abs(num - result[index-1]);
//					if(usedDiff.add(diff)) {
//						diffAdded=true;// didn't exist earlier
//					}
//					if(usedDiff.size() > k) {
//						if(diffAdded) usedDiff.remove(diff);// don't forget to remove it
//						continue; // pruned
//					}
//				}
//				result[index]=num;
//				used.add(num);
//				backtrack(n, k, result, index+1, used, usedDiff);
//				used.remove(num);
//				if(diffAdded) usedDiff.remove(diff);
//			}
//		}
//	}
	public static void main(String[] args) {
		BeautifulArrangement2 ba2= new BeautifulArrangement2();
		for(int i: ba2.constructArray(3, 1)) System.out.printf("%2d", i);
		System.out.println();
		for(int i: ba2.constructArray(3, 2)) System.out.printf("%2d", i);
		System.out.println();
		for(int i: ba2.constructArray(92, 80)) System.out.printf("%3d", i);
		System.out.println();
	}
}
