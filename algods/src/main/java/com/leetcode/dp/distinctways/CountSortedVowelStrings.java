package com.leetcode.dp.distinctways;
/**
 * 1641. Count Sorted Vowel Strings
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
 

Constraints:

1 <= n <= 50 
 */
import static org.junit.Assert.assertEquals;
public class CountSortedVowelStrings {
	/**
	 * DP: bottom up
	 * dp[6][n+1]
	 * dp[1][n]=1 and dp[v][1]=v
	 * dp[v][n]=dp[v-1][n]+dp[v][n-1]
	 * return dp[5][n]
	 * O(N)/ O(N) 100%
	 */
	public int countVowelStrings(int n) {
		int[][] dp=new int[6][n+1];
		for(int v=1; v<=5; v++) dp[v][1]=v;// when n=1, I can have v combo
		for(int i=1; i<=n; i++) dp[1][i]=1;// when v=1, I can have 1 combo
		for(int i=2; i<=n; i++) {
			for(int v=2; v<=5; v++) {
				dp[v][i]=dp[v-1][i]+dp[v][i-1];
			}
		}
		return dp[5][n];
	}
	/**
	 * Approach 05: Recursion + memo[6][n+1]
	 * O(N)/ O(N) 100%
	 */
//	int[][] memo;
//	public int countVowelStrings(int n) {
//		memo=new int[6][n+1];// v+1, n+1
//		return count(n, 5); 
//	}
//	private int count(int n, int v) {
//		if(v==1) return 1;
//		if(n==1) return v;
//		if(memo[v][n]==0) {
//			memo[v][n]=count(n, v-1)+count(n-1, v);
//		}
//		return memo[v][n];
//	}
	/**
	 * Approach 04: Recursion
	 * for n=2, v=3 (a, e, i), result=6 [aa, ae, ai, ee, ei, ii]
	 * for n=1, v=4 (a, e, i, o), result=4 [a, e, i, o]
	 * for n=2, v=4 (a, e, i, o), result=10 [aa, ae, ai, ee, ei, ii + (a, e, i, o).o]
	 * => n2v4=n2v3 + n1v4
	 * => nv=n(v-1) + (n-1)v
	 * Base Cases: when n=1, result=v (a,e,i,o,u); when v=1 (a), result=1;
	 */
//	public int countVowelStrings(int n) {
//		return count(n, 5); 
//	}
//	private int count(int n, int v) {
//		if(v==1) return 1;
//		if(n==1) return v;
//		return count(n, v-1)+count(n-1, v);
//	}
	/**
	 * Going through solutions: Approach 03: backtracking
	 * O(n^5)/ O(n) recursion stack
	 */
//	public int countVowelStrings(int n) {
//        return countVowelStringUtil(n, 1);
//    }
//
//    int countVowelStringUtil(int n, int vowels) {
//        if (n == 0)
//            return 1;
//        int result = 0;
//        for (int i = vowels; i <= 5; i++) {
//            result += countVowelStringUtil(n - 1, i);
//        }
//        return result;
//    }
	/**
	 * Approach 02: Backtracking with Memo [6][n+1]
	 * Improved performance, but I'm sure there will be a mathemagical way as well
	 */
//	int[][] memo;
//	public int countVowelStrings(int n) {
//		int count=0;
//		memo=new int[6][n+1];
//        for(int i=1; i<=5; i++) count+=backtrack(i,n-1);
//        return count;
//    }
//	private int backtrack(int start, int remaining) {
////		System.out.println(":"+start);
//		
//		if(remaining == 0) {
//			return 1;
//		}
//		if(memo[start][remaining] ==0) { 
//			for(int i=start; i<=5; i++) {
//				memo[start][remaining]+=backtrack(i,remaining-1);
//			}
//		}
//		return memo[start][remaining];
//	}
	/**
	 * Approach 01: Backtracking
	 * O(N^5)/ O(N^5) => 25%, 47%
	 */
//	int count;
//	public int countVowelStrings(int n) {
//		count=0;
//        for(int i=1; i<=5; i++) backtrack(i,n-1);
//        return count;
//    }
//	private void backtrack(int start, int remaining) {
////		System.out.println(":"+start);
//		if(remaining == 0) {
//			count+=1;
//			return;
//		}
//		for(int i=start; i<=5; i++) {
//			backtrack(i,remaining-1);
//		}
//	}
	public static void main(String[] args) {
		CountSortedVowelStrings csvs= new CountSortedVowelStrings();
		assertEquals(5,csvs.countVowelStrings(1));
		assertEquals(15,csvs.countVowelStrings(2));
		assertEquals(66045,csvs.countVowelStrings(33));
		assertEquals(316251,csvs.countVowelStrings(50));
	}
}
