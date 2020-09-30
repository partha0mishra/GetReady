package com.algods.leetcode.arrays;
/* 1351. Count Negative Numbers in a Sorted Matrix
 * 
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 

Return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 * */
public class NegativeIntegersSortedMatrix {
	/* Approach 02: 
	 * Start with Top right: if it's <0 the rest of the column at bottom is <0. Go left and repeat.
	 * Else, go down and Repeat.*/
	public int countNegatives(int[][] grid) {
		int rows=grid.length, cols=grid[0].length, r=0, c=cols-1, count=0;
		while(r < rows && c >=0) {
			int start=grid[r][c];
			if(start < 0) {count+=rows-r;c--;}
			else r++;
		}
		return count;
	}
	/* Approach 01: Brute with some optimization*/
//	public int countNegatives(int[][] grid) {
//        int count=0, cols=grid[0].length;
//        for(int r=0; r< grid.length; r++)
//            for(int c=0; c< cols; c++)
//                if(grid[r][c] < 0) {count+=cols-c; break;}
//        return count;
//    }
}
