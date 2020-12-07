package com.algods.leetcode.arrays;
/* 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
import java.util.*;
public class SpiralMatrix {
	/* Approach 01: Brute Force - O(mn) O(1) */
	int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
	public List<Integer> spiralOrder(int[][] matrix) {
		/*Brute force. Traverse the matrix. O(mn) O(1) */
        List<Integer> result=new ArrayList<Integer>();
        int x=0, y=0, d=0, m=matrix.length, n=matrix[0].length, elements=m*n
        		, minX=0// IMPORTANT !!
        		, minY=-1;
        for(int i=0; i< elements; i++) {
       	System.out.println(x+" "+y+" "+i);
        	result.add(matrix[x][y]);
        	int tempX=x+dirs[d][0];// temp
        	int tempY=y+dirs[d][1];// temp
        	if(d == 0 && tempY == n) {d=(d+1)%4; n-=1;}
        	if(d == 1 && tempX == m) {d=(d+1)%4; m-=1;}
        	if(d == 2 && tempY == minY) {d=(d+1)%4; minY+=1;}
        	if(d == 3 && tempX == minX) {d=(d+1)%4; minX+=1;}
        	
        	x=x+dirs[d][0];// new x
        	y=y+dirs[d][1];// new y
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println(new SpiralMatrix().spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
	}
}
