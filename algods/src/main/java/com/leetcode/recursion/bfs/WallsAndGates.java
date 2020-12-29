package com.leetcode.recursion.bfs;
/* 286. Walls and Gates
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
import java.util.*;
public class WallsAndGates {
	/* Add ALL Gates to the queue and then do BFS to all the empty (INF) rooms 
	 * O(mn) O(mn)*/
	public static final int GATE=0, WALL=-1, INF=Integer.MAX_VALUE;
	public void wallsAndGates(int[][] rooms) {
		if(rooms.length ==0) return;
        int rows=rooms.length, cols=rooms[0].length;
        int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q=new ArrayDeque<>();
        for(int r=0; r< rows; r++)
        	for(int c=0; c< cols; c++)
        		if(rooms[r][c] == GATE)
        			q.offer(new int[]{r,c});
        			
			while(!q.isEmpty()) {
				int[] room=q.poll();
				for(int[] dir:dirs) {
					int newRow=room[0]+dir[0];
					int newCol=room[1]+dir[1];
					if(newRow < 0 || newCol < 0 || newRow == rows || newCol == cols) continue;
					if(rooms[newRow][newCol] == INF) {
                        rooms[newRow][newCol]=rooms[room[0]][room[1]]+1;// 0 -> 1 -> 2 -> 3 since -1=WALL
					    q.offer(new int[] {newRow,newCol});
                    }
				}
			}
    }
}
