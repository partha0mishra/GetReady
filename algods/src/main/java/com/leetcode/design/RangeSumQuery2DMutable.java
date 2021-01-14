package com.leetcode.design;
/** TODO Anki 
 * TODO : this is NOT most optimized but it works so far
 * 
 * 308. Range Sum Query 2D - Mutable
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {
	/**
	 * Approach 01: Brute and STILL NOT TLE :O
	 * update : O(1)
	 * sumRegion : O(m*n)
	 * space: O(1)
	 */
	class NumMatrix {
		int[][] mat;
	    public NumMatrix(int[][] matrix) {
	        this.mat=matrix;
	    }
	    
	    public void update(int row, int col, int val) {
	        mat[row][col]=val;
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	    	int sum=0;
	        for(int r=row1; r<=row2; r++)
	        	for(int c=col1; c<=col2; c++)
	        		sum+=mat[r][c];
	        return sum;
	    }
	}

	/**
	 * Your NumMatrix object will be instantiated and called as such:
	 * NumMatrix obj = new NumMatrix(matrix);
	 * obj.update(row,col,val);
	 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
