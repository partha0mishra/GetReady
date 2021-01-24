package com.leetcode.arrays;
/**
 * Sort the Matrix Diagonally
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
Example 1:
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
1 <= mat[i][j] <= 100
*
* Hint 01: Use a data structure to store all values of each diagonal.
* Hint 02: How to index the data structure with the id of the diagonal?
* Hint 03: All cells in the same diagonal (i,j) have the same difference so we can get the diagonal of a cell using the difference i-j.
 */
import java.util.*;
public class DiagonalMatrixSort {
	/**
	 * [3,3,1,1]
	 * [2,2,1,2]
	 * [1,1,1,2]
	 * 
	 * Approach 01: brute
	 * Start from bottom left (row = rows-1, col = 0) -> up to row = 0
	 * then for row 0, go col=1 to col = cols-1
	 * call arrange() function that moves r+1, c+1 and saves values in an ArrayList temp
	 * Sort the ArrayList temp
	 * go through the same r+1, c+1 in the result[][] and populate with ArrayList temp.get(index++)
	 * 
	 * Sorting takes O(r.c log(min(r,c)), rest all takes O(N). complexity O(N logN)
	 * Here, N is really min(rows, cols)
	 * 
	 * Extra space: max size of diagonal O(min(rows, cols))
	 */
	int rows, cols;
	int[][] result;
	public int[][] diagonalSort(int[][] mat) {
        rows=mat.length; cols=mat[0].length;
        if(rows == 1 || cols== 1) return mat;// single row or single col
        result=new int[rows][cols];
        for(int r=rows-1; r>=0; r--)
        	arrangeDiag(mat, r, 0);
        for(int c=1; c< cols; c++)
        	arrangeDiag(mat, 0, c);
        return result;
    }
	private void arrangeDiag(int[][] mat, int row, int col) {
		int r=row, c=col;
		ArrayList<Integer> temp=new ArrayList<>();
		while(r< rows && c< cols) {
			temp.add(mat[r++][c++]);
		}
		Collections.sort(temp);
		r=row; c=col;
		int index=0;
		while(r< rows && c< cols) {
			result[r++][c++]=temp.get(index++);
		}
	}
	public static void main(String[] args) {
		int[][] r=new DiagonalMatrixSort().diagonalSort(new int[][] {{3,3,1,1},{2,2,1,2},{1,1,1,2}});
		printMatrix(r);
	}
	public static void printMatrix(int[][] m) {
		for(int r=0; r< m.length; r++) {
			for(int c=0; c< m[0].length; c++) {
				System.out.printf("%2d", m[r][c]);
			}
			System.out.println();
		}
	}
}
