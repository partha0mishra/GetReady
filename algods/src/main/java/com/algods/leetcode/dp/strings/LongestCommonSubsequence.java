package com.algods.leetcode.dp.strings;
/**
 * 1143. Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 */
import static org.junit.Assert.assertEquals;
public class LongestCommonSubsequence {
	/**
	 * Very well-written official LC Solution: https://leetcode.com/problems/longest-common-subsequence/solution/
	 * Recursive:
	 * define function LCS(text1, text2):
    # If either string is empty there can be no common subsequence
    if length of text1 or text2 is 0:
        return 0

    letter1 = the first letter in text1

    # The case where the line *is not* part of the optimal solution
    case1 = LCS(text1.substring(1), text2)

    case2 = 0
    if letter1 is in text2:
        firstOccurence = first position of letter1 in text2
        # The case where the line *is* part of the optimal solution
        case2 = 1 + LCS(text1.substring(1), text2.substring(firstOccurence + 1))

    return maximum of case1 and case2
	 *
	 * Complexity Analysis:
	 * number of subproblems = M*N.
	 * in each, we search through the second substring => O(N)
	 * final complexity O(T) = O(MN^2)
	 * O(M) = O(M*N)
	 */

	private int[][] memo;
	private String text1;
	private String text2;

	public int longestCommonSubsequence(String text1, String text2) {
		// Make the memo big enough to hold the cases where the pointers
		// go over the edges of the strings.
		this.memo = new int[text1.length() + 1][text2.length() + 1];
		// We need to initialise the memo array to -1's so that we know
		// whether or not a value has been filled in. Keep the base cases
		// as 0's to simplify the later code a bit.
		for (int i = 0; i < text1.length(); i++) {
			for (int j = 0; j < text2.length(); j++) {
				this.memo[i][j] = -1;
			}
		}
		this.text1 = text1;
		this.text2 = text2;
		return memoSolve(0, 0);
	}

	private int memoSolve(int p1, int p2) {        
		// Check whether or not we've already solved this subproblem.
		// This also covers the base cases where p1 == text1.length
		// or p2 == text2.length.
		if (memo[p1][p2] != -1) {
			return memo[p1][p2];
		}

		// Option 1: we don't include text1[p1] in the solution.
		int option1 = memoSolve(p1 + 1, p2);

		// Option 2: We include text1[p1] in the solution, as long as
		// a match for it in text2 at or after p2 exists.
		int firstOccurence = text2.indexOf(text1.charAt(p1), p2);
		int option2 = 0;
		if (firstOccurence != -1) {
			option2 = 1 + memoSolve(p1 + 1, firstOccurence + 1);
		}

		// Add the best answer to the memo before returning it.
		memo[p1][p2] = Math.max(option1, option2);
		return memo[p1][p2];
	}
	/**
	 * DP: Pattern of 'DP on Strings'
	 * O(m*n)/ O(m*n)
	 */
//	public int longestCommonSubsequence(String text1, String text2) {
//		int l1=text1.length(), l2=text2.length();
//		int[][] dp= new int[l1+1][l2+1];
//        for(int i=1; i<= text1.length(); i++)
//        	for(int j=1; j<=text2.length(); j++)
//        		if(text1.charAt(i-1) == text2.charAt(j-1)) 	dp[i][j]=dp[i-1][j-1]+1;
//        		else 										dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
//        return dp[l1][l2];
//    }
	public static void main(String[] args) {
		assertEquals(3,new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
		assertEquals(3,new LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"));
		assertEquals(0,new LongestCommonSubsequence().longestCommonSubsequence("abc", "def"));
	}
}
