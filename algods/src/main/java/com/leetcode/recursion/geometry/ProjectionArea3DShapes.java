package com.leetcode.recursion.geometry;

import java.util.Arrays;

/* 883. Projection Area of 3D Shapes
 * 
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Now we view the projection of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane. 

Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.

 

Example 1:

Input: [[2]]
Output: 5
Example 2:

Input: [[1,2],[3,4]]
Output: 17
Explanation: 
Here are the three projections ("shadows") of the shape made with each axis-aligned plane.

Example 3:

Input: [[1,0],[0,2]]
Output: 8
Example 4:

Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 14
Example 5:

Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 21
 

Note:

1 <= grid.length = grid[0].length <= 50
0 <= grid[i][j] <= 50
 * */
public class ProjectionArea3DShapes {
	/* Approach 02: a little better*/
	public int projectionArea(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 0; j < n; ++j) {
                x = Math.max(x, grid[i][j]);
                y = Math.max(y, grid[j][i]);
                if (grid[i][j] > 0) ++res;
            }
            res += x + y;
        }
        return res;
    }
	/* Approach 01: straight-forward grid */
//	public int projectionArea(int[][] grid) {
//        int result=0, n=grid.length;
//        int[] maxRow=new int[n], maxCol=new int[n];
//        for(int i=0; i<n; i++) {
//        	for(int j=0; j<n; j++) {
//        		if(grid[i][j] > 0) result+=1; //xz
//        		maxRow[i]=Math.max(maxRow[i], grid[i][j]);
//        		maxCol[j]=Math.max(maxCol[j], grid[i][j]);
//        	}
//        }
//        result+=Arrays.stream(maxRow).sum();
//        result+=Arrays.stream(maxCol).sum();
//        return result;
//    }
	public static void main(String[] args) {
		System.out.println(new ProjectionArea3DShapes().projectionArea(new int[][] {{2}}));//5
		System.out.println(new ProjectionArea3DShapes().projectionArea(new int[][] {{1,2},{3,4}}));//17
		System.out.println(new ProjectionArea3DShapes().projectionArea(new int[][] {{1,0},{0,2}}));//8
		System.out.println(new ProjectionArea3DShapes().projectionArea(new int[][] {{1,1,1},{1,0,1},{1,1,1}}));//14
		System.out.println(new ProjectionArea3DShapes().projectionArea(new int[][] {{2,2,2},{2,1,2},{2,2,2}}));//21
	}
}
