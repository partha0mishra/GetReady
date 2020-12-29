package com.leetcode.recursion.dp;
/* Cherry Pickup II
 * Given a rows x cols matrix grid representing a field of cherries. Each cell in grid represents the number of cherries that you can collect.

You have two robots that can collect cherries for you, Robot #1 is located at the top-left corner (0,0) , and Robot #2 is located at the top-right corner (0, cols-1) of the grid.

Return the maximum number of cherries collection using both robots  by following the rules below:

From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
When both robots stay on the same cell, only one of them takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in the grid.
 

Example 1:



Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
Example 2:



Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
Example 3:

Input: grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
Output: 22
Example 4:

Input: grid = [[1,1],[1,1]]
Output: 4
 

Constraints:

rows == grid.length
cols == grid[i].length
2 <= rows, cols <= 70
0 <= grid[i][j] <= 100 
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class CherryPickup2 {
	/* O(MN^2) M rows, N columns */
	public int cherryPickup(int[][] grid) {
        int rows=grid.length, cols=grid[0].length;
        int[][][] dp=new int[rows][cols][cols];
        for(int r=0; r< rows; r++)
        	for(int c=0; c< cols; c++)
        		Arrays.fill(dp[r][c], -1);// initialize
        
        return getCherries(grid, dp, 0, 0, cols-1);
    }
	private int getCherries(int[][] grid, int[][][] dp, int row, int col1, int col2) {
		if(dp[row][col1][col2] == -1) {
			int dpHere=0;
			if(row < grid.length -1) {
				for(int i=-1; i<2; i++)
					for(int j=-1; j<2; j++) {
						int newCol1= col1+ i;
						int newCol2= col2+ j;
						if(newCol1 < 0 || newCol2 < 0 || newCol1 >= grid[0].length || newCol2 >= grid[0].length) continue;
						else dpHere=Math.max(dpHere, getCherries(grid,dp,row+1,newCol1,newCol2));
					}
			}
			int val=grid[row][col1];
			if(col1 != col2) val+=grid[row][col2];
			dp[row][col1][col2]=dpHere+val;
			dp[row][col2][col1]=dp[row][col1][col2];
			System.out.println("["+row+","+col1+","+col2+"] local:"+dpHere+" g[r][c1][c2]"+grid[row][col1]+", "
								+grid[row][col2]+" DP:"+dp[row][col1][col2]);
		}
		return dp[row][col1][col2];
	}
	public static void main(String[] args) {
		CherryPickup2 cp2= new CherryPickup2();
		assertEquals(24,cp2.cherryPickup(new int[][] {{3,1,1},{2,5,1},{1,5,5},{2,1,1}}));
		assertEquals(28,cp2.cherryPickup(new int[][] {{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}}));
		assertEquals(22,cp2.cherryPickup(new int[][] {{1,0,0,3},{0,0,0,3},{0,0,3,3},{9,0,3,3}}));
		assertEquals(4,cp2.cherryPickup(new int[][] {{1,1},{1,1}}));
	}

}
