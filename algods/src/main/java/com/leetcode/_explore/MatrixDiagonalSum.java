package com.leetcode;
/**
 * Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

 

Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:

Input: mat = [[5]]
Output: 5
 

Constraints:

n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100
 *
 */
public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
    	if(mat.length == 1) return mat[0][0];
    	int first=0, result=0;
    	int last=mat[0].length -1;
        for(int row=0; row < mat.length; row++) {
        	System.out.println("Row: "+row+" first: "+first+" last: "+last);
        	if(mat.length %2 !=0 && last==mat.length/2) {
        		// do nothing
        		System.out.println("done nothing");
        		result+=mat[row][first];
        	}else {
        		result+=mat[row][first]+mat[row][last];
        	}
        	System.out.println("elements: "+mat[row][first]+" "+mat[row][last]+" result: "+result);
        	first++;
        	last--;
        }
        return result;
    }
	public static void main(String[] args) {
		MatrixDiagonalSum instance= new MatrixDiagonalSum();
		int[][] input01= {{1,2,3},
		                  {4,5,6},
		                  {7,8,9}};
		System.out.println(instance.diagonalSum(input01));
		int[][] input02= {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		System.out.println(instance.diagonalSum(input02));
		int[][] input03= {{5}};
		System.out.println(instance.diagonalSum(input03));
	}

}
