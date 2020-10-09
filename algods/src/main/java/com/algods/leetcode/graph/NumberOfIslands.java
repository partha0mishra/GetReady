package com.algods.leetcode.graph;
/* 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length==0) return 0;
        int[][] map=new int[grid.length][grid[0].length];
        int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
        int count=0;
        for(int row=0; row< grid.length; row++)
            for(int col=0; col< grid[0].length; col++)
                if(grid[row][col] == '1' && map[row][col] ==0){
                	count+=1;
                    dfs(grid,row,col,map,count,dir);
                }
        return count;
    }

	private void dfs(char[][] grid, int row, int col, int[][] map, int count, int[][] dir) {
		map[row][col]=count;
		printMap(map);
        System.out.println(row+" "+col+" "+count);
		for(int[] d: dir) {
			int r=row+d[0], c=col+d[1];
			if(r >= 0 && r< grid.length && c >= 0 && c < grid[0].length) {
				if(grid[r][c] == '1' && map[r][c] ==0) {
					dfs(grid,r,c,map,count,dir);
				}
			}
		}
	}
	public static void main(String[] args) {
		NumberOfIslands instance= new NumberOfIslands();
		char[][] grid= new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(instance.numIslands(grid));
	}
	private void printMap(int[][] map) {
		for(int i=0; i< map.length; i++) {
			for(int j=0; j< map[0].length; j++) 
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
}
