package com.leetcode.recursion.arrays;
/* 59. Spiral Matrix II
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * Example 1:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 * Constraints:
 * 1 <= n <= 20
 */
public class SpiralMatrix2 {
	int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
	public int[][] generateMatrix(int n) {
		/*Brute force. Traverse the matrix. O(n2) O(1) */
        int[][] result=new int[n][n];
        int x=0, y=0, d=0;
        for(int i=1; i<= n*n; i++) {
//        	System.out.println(x+" "+y+" "+i);
        	result[x][y]=i;
        	int tempX=x+dirs[d][0];// temp
        	int tempY=y+dirs[d][1];// temp
        	if(tempX == n || tempY == n || tempX == -1 || tempY == -1 || result[tempX][tempY] !=0) {// changing direction
//        		d+=1;
//        		if(d == 4) d=0;
        		d=(d+1)%4; // better way than the last 2 lines
            	tempX=x+dirs[d][0];// new x
            	tempY=y+dirs[d][1];// new y
        	}
        	x=tempX; y=tempY;
        }
        return result;
    }
	public static void main(String[] args) {
		int[][] result= new SpiralMatrix2().generateMatrix(1);
		printMatrix(result);
		result= new SpiralMatrix2().generateMatrix(2);
		printMatrix(result);
		result= new SpiralMatrix2().generateMatrix(3);
		printMatrix(result);
		result= new SpiralMatrix2().generateMatrix(4);
		printMatrix(result);
		result= new SpiralMatrix2().generateMatrix(5);
		printMatrix(result);
	}
	private static void printMatrix(int[][] result) {
		int row=result.length, col=result[0].length;
		for(int r=0; r< row; r++) {
			for(int c=0; c< col; c++) {
				System.out.printf("%3d ", result[r][c]);
			}
			System.out.println();
		}
	}
}
