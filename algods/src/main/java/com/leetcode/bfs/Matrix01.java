package com.leetcode.bfs;
/* 01 Matrix
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 

Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 */
import java.util.*;
public class Matrix01 {
	public int[][] updateMatrix(int[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length;
        int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited=new boolean[rows][cols];// bitmap
        Deque<int[]> queue=new ArrayDeque<>();
        for(int r=0; r< rows; r++)
        	for(int c=0; c< cols; c++)
        		if(matrix[r][c] ==0) {
                    visited[r][c]=true;// IMPORTANT
                    queue.offerLast(new int[] {r,c});
                }
        while(!queue.isEmpty()) {
        	int size=queue.size();
        	for(int i=0; i< size; i++) {
        		int[] point=queue.pollFirst();
            		for(int[] d: dirs) {
            			int r=point[0]+d[0];
            			int c=point[1]+d[1];
            			if(r >=0 && c>=0 && r< rows && c< cols 
            					&& matrix[r][c] !=0 && !visited[r][c]) {
            				matrix[r][c]=matrix[point[0]][point[1]]+1;// that's enough
                            visited[r][c]=true;// IMPORTANT
            				queue.offerLast(new int[] {r,c});
            			}
            		}
            	}
        	}
        return matrix;
    }
}
