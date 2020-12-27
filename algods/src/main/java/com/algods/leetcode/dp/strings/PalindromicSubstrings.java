package com.algods.leetcode.dp.strings;
/**
 * 647. Palindromic Substrings
 * Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
 */
import static org.junit.Assert.assertEquals;
public class PalindromicSubstrings {
	/**
	 * Take every index and extend both sides to find biggest palindrome 
	 * O(N^2)
	 */
	int count = 0;

	public int countSubstrings(String s) {
		if (s == null || s.length() == 0) return 0;

		for (int i = 0; i < s.length(); i++) { // i is the mid point
			extendPalindrome(s, i, i); // odd length;
			extendPalindrome(s, i, i + 1); // even length
		}

		return count;
	}

	private void extendPalindrome(String s, int left, int right) {
		while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++; left--; right++;
		}
	}
	/**
	 * DP Pattern way : DOESN'T work yet
	 */
//	public int countSubstrings(String s) {
//        int n=s.length();
//        int[][] dp=new int[n+1][n+1];
//        for (int l = 1; l < n; ++l) {
//        	for (int i = 0; i < n-l; ++i) {
//        		int j = i + l;
//        		if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == j-i-1) {
//        			dp[i][j] = dp[i+1][j-1] + 2;
//        		} else {
//        			dp[i][j] = 0;
//        		}
//        	}
//        }
//        return dp[n][n];
//    }
	public static void main(String[] args) {
		assertEquals(3,(new PalindromicSubstrings().countSubstrings("abc")));
		assertEquals(6,(new PalindromicSubstrings().countSubstrings("aaa")));
	}
}
