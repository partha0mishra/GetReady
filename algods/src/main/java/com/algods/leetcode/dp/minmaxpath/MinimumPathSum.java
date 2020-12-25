package com.algods.leetcode.dp.minmaxpath;
/* 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100 
 */
public class MinimumPathSum {
	/* Actually we can go row by row and reach the last column of last row
	 * we need to carry over the DP for the last row, so a row level [] is enough
	 * For column, we just need to keep previous column value
	 * O(m*n)/ O(n)
	 */
	public int minPathSum(int[][] grid) {
		int rows=grid.length, cols=grid[0].length, prev;
        int[] dp= new int[cols];
        for(int r=0; r< rows;r++) {
        	prev=0;
        	for(int c=0; c< cols; c++) {
        		if(c ==0) dp[c]=dp[c]+grid[r][c];
        		else if(r == 0) dp[c]=prev+grid[r][c];
        		else dp[c]=Math.min(dp[c], prev)+grid[r][c];
        		prev=dp[c];
        	}
        }
        return dp[cols-1];
    }
}
