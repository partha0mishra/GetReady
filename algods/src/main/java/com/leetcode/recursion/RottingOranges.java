package com.leetcode.recursion;
import static org.junit.Assert.assertEquals;

/**
 * In a given grid, each cell can have one of three values:
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  
 * If this is impossible, return -1 instead.
 * 
 * Example 01:
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * 
 * Example 02:
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, 
 * because rotting only happens 4-directionally.
 * 
 * Example 03:
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * 
 * Constraints:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
import java.util.*;
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
    	Queue<int[]> rottenQueue=new LinkedList<int[]>();
    	int freshOranges=0;
    	for(int row=0; row<grid.length; row++)
    		for(int col=0; col<grid[0].length; col++) {
    			if(grid[row][col] == 2) rottenQueue.add(new int[] {row,col});
    			else if(grid[row][col] == 1) freshOranges++;
    		}
    	int[][] dirVector= {{1,0},{0,1},{-1,0},{0,-1}};
    	int minutes=0;
    	while(!rottenQueue.isEmpty() && freshOranges !=0) {
    		minutes++;// let's talk about next minute
    		int size=rottenQueue.size();
    		while(size -- > 0) {
    			int[] xy=rottenQueue.poll();
    			for(int[] dir: dirVector) {
    				int x=xy[0]+dir[0];
    				int y=xy[1]+dir[1];
    				if(x < 0 || y< 0 ||x >= grid.length || y >= grid[0].length // outside grid
    						|| grid[x][y] ==0 // Empty 
    						|| grid[x][y] ==2)// rotten
    					continue;
    				rottenQueue.add(new int[] {x,y});
    				grid[x][y]=2;
    				freshOranges --;
    			}
    		}
    	}
    	if(freshOranges == 0)
    		return minutes;
    	else
    		return -1;
    }
	public static void main(String[] args) {
		RottingOranges instance= new RottingOranges();
		int[][] grid01= {{2,1,1},{1,1,0},{0,1,1}};
		assertEquals("01",4,instance.orangesRotting(grid01));
		int[][] grid02= {{2,1,1},{0,1,1},{1,0,1}};
		assertEquals("02",-1,instance.orangesRotting(grid02));
		int[][] grid03= {{0,2}};
		assertEquals("03",0,instance.orangesRotting(grid03));
	}

}
