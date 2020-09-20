package com.algods.leetcode;
/**
 * Maximum non-negative product of a matrix
 * 
 * You are given a rows x cols matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (rows - 1, cols - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative return -1.

Notice that the modulo is performed after getting the maximum product.

 

Example 1:

Input: grid = [[-1,-2,-3],
               [-2,-3,-3],
               [-3,-3,-2]]
Output: -1
Explanation: It's not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
Example 2:

Input: grid = [[1,-2,1],
               [1,-2,1],
               [3,-4,1]]
Output: 8
Explanation: Maximum non-negative product is in bold (1 * 1 * -2 * -4 * 1 = 8).
Example 3:

Input: grid = [[1, 3],
               [0,-4]]
Output: 0
Explanation: Maximum non-negative product is in bold (1 * 0 * -4 = 0).
Example 4:

Input: grid = [[ 1, 4,4,0],
               [-2, 0,0,1],
               [ 1,-1,1,1]]
Output: 2
Explanation: Maximum non-negative product is in bold (1 * -2 * 1 * -1 * 1 * 1 = 2).
 

Constraints:

1 <= rows, cols <= 15
-4 <= grid[i][j] <= 4

 */
public class MaximumNonNegativeMatrixProduct {
	long maxProduct= -1;
	public int maxProductPath(int[][] grid) {
		int mod=1000000007;
		int x=0, y=0, endx=grid.length -1, endy=grid[0].length -1;
		dfs(grid, x, y, endx, endy, 1);
//		System.out.println("before mod: "+maxProduct);
		return (int) (maxProduct% mod);
    }
	private void dfs(int[][] grid, int x, int y, int endx, int endy, long productSoFar) {
		if(grid[x][y] ==0) return;
		productSoFar*=grid[x][y];
		int right=y+1;
		int down=x+1;
		if((right > endy && down > endx) || productSoFar ==0) {
			if(productSoFar > maxProduct) maxProduct=productSoFar;
			return;
		}
		if(right <= endy) dfs(grid, x, right, endx, endy, productSoFar);
		if(down <= endx)  dfs(grid, down, y,  endx, endy, productSoFar);
	}
	public static void main(String[] args) {
		MaximumNonNegativeMatrixProduct instance= new MaximumNonNegativeMatrixProduct();
		int[][] grid01=new int[][] {{1,-2,1},
		                            {1,-2,1},
		                            {3,-4,1}};
		System.out.println(instance.maxProductPath(grid01));
		int [][] grid02= new int[][] {{1,-4,2},
									  {4,3,-1},
									  {2,-4,4},
									  {1,-1,-4}};
		System.out.println(instance.maxProductPath(grid02));
		int[][] grid03= new int[][] {{1,-1,2,1,-1,0,0,4,3,2,0,-2,-2},
									 {-2,3,3,-1,-1,0,0,-2,4,-3,3,0,0},
									 {-4,-1,-1,-2,2,-1,-2,-2,0,3,-1,-4,1},
									 {-3,4,-3,0,-3,1,-3,1,4,4,-4,-4,-2},
									 {3,-3,1,0,-1,-4,-4,-4,3,2,2,3,3},
									 {2,-1,-1,-4,-3,-3,4,2,3,4,4,-4,0},
									 {4,-1,2,-3,-1,-1,-3,-4,4,4,4,-3,-1},
									 {-3,-4,4,-2,-1,2,3,-1,2,3,4,4,-4},
									 {-3,-1,-2,1,1,-1,-3,-4,-3,1,-3,3,-4},
									 {2,4,4,4,-3,-3,1,-1,3,4,-1,1,4},
									 {2,-2,0,4,-1,0,-2,4,-4,0,0,2,-3},
									 {1,1,-3,0,-4,-4,-4,-4,0,-1,-4,-1,0},
									 {3,-1,-3,-3,-3,-2,-1,4,-1,-2,4,2,3}};
		System.out.println(instance.maxProductPath(grid03));
		
	}

}
