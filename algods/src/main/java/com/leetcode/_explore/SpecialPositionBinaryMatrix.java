package com.leetcode._explore;
/***
 * 1582. Special Positions in a Binary Matrix
 * 
 * Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the number of special positions in mat.

A position (i,j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

 

Example 1:

Input: mat = [[1,0,0],
              [0,0,1],
              [1,0,0]]
Output: 1
Explanation: (1,2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Example 2:

Input: mat = [[1,0,0],
              [0,1,0],
              [0,0,1]]
Output: 3
Explanation: (0,0), (1,1) and (2,2) are special positions. 
Example 3:

Input: mat = [[0,0,0,1],
              [1,0,0,0],
              [0,1,1,0],
              [0,0,0,0]]
Output: 2
Example 4:

Input: mat = [[0,0,0,0,0],
              [1,0,0,0,0],
              [0,1,0,0,0],
              [0,0,1,0,0],
              [0,0,0,1,1]]
Output: 3
 

Constraints:

rows == mat.length
cols == mat[i].length
1 <= rows, cols <= 100
mat[i][j] is 0 or 1.
 */
//import java.util.*;
import static org.junit.Assert.assertEquals;
public class SpecialPositionBinaryMatrix {
	public int numSpecial(int[][] mat) {
        int[] rowCount= new int[mat.length], colCount= new int[mat[0].length];
        int result=0;
        for(int row=0; row< mat.length; row++)// first pass - collect cols on rows and cols
        	for(int col=0; col< mat[0].length; col++) {
        		rowCount[row]+=mat[row][col];
        		colCount[col]+=mat[row][col];
        	}
        for(int row=0; row< mat.length; row++)
        	for(int col=0; col< mat[0].length; col++)
        		if(mat[row][col] ==1 && rowCount[row]==1 && colCount[col]==1) result++;
        
        return result;
    }
	public static void main(String[] args) {
		SpecialPositionBinaryMatrix instance = new SpecialPositionBinaryMatrix();
		int[][] matrix1=new int[][]{{1,0,0},
									{0,0,1},
									{1,0,0}};
		assertEquals(1,instance.numSpecial(matrix1));
		int[][] matrix2=new int[][] {{1,0,0},
									 {0,1,0},
									 {0,0,1}};
	    assertEquals(3,instance.numSpecial(matrix2));
	    int[][] matrix3=new int[][] {{0,0,0,1},
			 						 {1,0,0,0},
			 						 {0,1,1,0},
			 						 {0,0,0,0}};
	    assertEquals(2,instance.numSpecial(matrix3));
	    int[][] matrix4=new int[][] {{0,0,0,0,0},
									 {1,0,0,0,0},
									 {0,1,0,0,0},
									 {0,0,1,0,0},
									 {0,0,0,1,1}};
		assertEquals(3,instance.numSpecial(matrix4));
		int[][] matrix5=new int[][] {{0,0,0,0,0,1,0,0}
									,{0,0,0,0,1,0,0,1}
									,{0,0,0,0,1,0,0,0}
									,{1,0,0,0,1,0,0,0}
									,{0,0,1,1,0,0,0,0}};
		assertEquals(1,instance.numSpecial(matrix5));
		assertEquals(0,instance.numSpecial(new int[][] {
			{0,0,0,0},
			{0,1,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,1,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,1,1,0}}));
	}

}
