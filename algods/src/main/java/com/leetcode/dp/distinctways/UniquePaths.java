package com.leetcode.dp.distinctways;

import java.util.Arrays;

// TODO Anki
/** 62. Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Example 1:
Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6 
 */
public class UniquePaths {
	/** Quite like min cost path - com.algods.leetcode.dp.minmaxpath.MinimumPathSum
	 * This time, instead of finding minimum, find ALL/ Sum/ Distinct ways
	 * We can start [0,0] with value 1. That's it.
	 * Keeping a dp array for all the columns.
	 * O(m*n) O(n)
	 */
	public int uniquePaths(int rows, int cols) {
		int[] dp=new int[cols];
		dp[0]=1;
        for(int r=0; r< rows; r++) {
        	for(int c=0; c< cols; c++) {
        		dp[c] += (c ==0)? 0: dp[c-1];
        	}
        	for(int i: dp) {System.out.printf("%4d",i);}
            System.out.println();
        }
        return dp[cols-1];
    }
	public static void main(String[] s) {
		UniquePaths up= new UniquePaths();
		up.uniquePaths(3, 5);
	}
}
