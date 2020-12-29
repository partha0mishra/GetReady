package com.leetcode.recursion.graph;
/* 5548. Path With Minimum Effort
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106

 */
import java.util.*;
public class MinEffortPath {
	/* Approach 02: Dijkstra */
//	public int minimumEffortPath(int[][] heights) {
//        int r=heights.length,c=heights[0].length;
//        int[][] dis=new int[r][c];
//        for(int[] d:dis)
//            Arrays.fill(d,Integer.MAX_VALUE);
//        dis[0][0]=0;
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[2]-b[2]));
//        pq.add(new int[]{0,0,0});
//        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
//        while(!pq.isEmpty()){
//            int[] temp=pq.poll();
//            for(int[] dir:dirs){
//                int x=temp[0]+dir[0],y=temp[1]+dir[1];
//                if(x<0||y<0||x>=r||y>=c) continue;
//                int max=Math.max(temp[2],Math.abs(heights[temp[0]][temp[1]]-heights[x][y]));
//                if(dis[x][y]>max){
//                    dis[x][y]=max;
//                    pq.add(new int[]{x,y,max});
//                }
//            }
//        }
//        System.out.println(dis[r-1][c-1]);
//        return dis[r-1][c-1];
//    }
	/* Dijkstra: another approach */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[] DIR = new int[]{0, 1, 0, -1, 0};
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0, 0}); // distance, row, col
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int d = top[0], r = top[1], c = top[2];
            if (r == m - 1 && c == n - 1) return d; // Reach to bottom right
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i], nc = c + DIR[i + 1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (dist[nr][nc] > newDist) {
                        dist[nr][nc] = newDist;
                        minHeap.offer(new int[]{dist[nr][nc], nr, nc});
                    }
                }
            }
        }
        return 0; // Unreachable code, Java require to return interger value.
    }
	/* Approach 03: BFS - surprisingly doesn't give TLE */
//	public int minimumEffortPath(int[][] heights)
//	{
//		int rows = heights.length;
//		int columns = heights[0].length;
//		int[][] memo = new int[rows][columns];
//		for (int[] row : memo){
//			Arrays.fill(row, Integer.MAX_VALUE);
//		}
//
//		Queue<int[]> queue = new LinkedList<>();
//		queue.add(new int[]{0, 0, heights[0][0], 0});
//		int[] current;
//		int row;
//		int column;
//		int prev;
//		int max;
//		while (!queue.isEmpty()) {
//			current = queue.remove();
//			row = current[0];
//			column = current[1];
//			prev = current[2];
//			max = current[3];
//			max = Math.max(max, Math.abs(prev - heights[row][column]));
//
//			if (max >= memo[row][column]) {
//				continue;
//			}
//
//			memo[row][column] = max;
//
//			if (row - 1 >= 0) {
//				queue.add(new int[]{row - 1, column, heights[row][column], max});
//			}
//
//			if (row + 1 < rows){
//				queue.add(new int[]{row + 1, column, heights[row][column], max});
//			}
//
//			if (column - 1 >= 0){
//				queue.add(new int[]{row, column - 1, heights[row][column], max});
//			}
//
//			if (column + 1 < columns){
//				queue.add(new int[]{row, column + 1, heights[row][column], max});
//			}
//		}
//
//		return memo[rows - 1][columns - 1];
//	}
	/*Approach 01: TLE */
//	int minEffort=Integer.MAX_VALUE;
//	public int minimumEffortPath(int[][] heights) {
//        int rStart=0, cStart=0, rEnd=heights.length-1, cEnd=heights[0].length-1;
//        int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
//        boolean[][] marked=new boolean[heights.length][heights[0].length];
//        dfs(rStart,cStart,heights,rEnd,cEnd,dir,marked,0);
//        // System.out.println(minEffort);
//        return minEffort;
//    }
//	private void dfs(int rStart, int cStart, int[][] heights, int rEnd, int cEnd, int[][] dir, boolean[][] marked, int effort) {
//		if(rStart == rEnd && cStart == cEnd) {
//			if(effort < minEffort) minEffort=effort;
//			return;}
//		marked[rStart][cStart]=true;
//		for(int[] d: dir) {
//			int rNext=rStart+d[0], cNext=cStart+d[1];
//			if(rNext <= rEnd && cNext <= cEnd && rNext >=0 && cNext >=0 && !marked[rNext][cNext]) {
//				int e=heights[rStart][cStart];
//				int eNext=heights[rNext][cNext];
//				int stepEffort=Math.abs(e-eNext);
//                // System.out.println(e+" "+eNext+" "+stepEffort);
//				int maxEffort= (stepEffort > effort)? stepEffort: effort;
//				dfs(rNext, cNext, heights, rEnd, cEnd, dir, marked, maxEffort);
//			}
//		}
//		marked[rStart][cStart]=false;
//	}
	public static void main(String[] args) {
		MinEffortPath instance = new MinEffortPath();
		instance.minimumEffortPath(new int[][] {{1,10,6,7,9,10,4,9}});
		instance.minimumEffortPath(new int[][] {{1,2,2},{3,8,2},{5,3,5}});
		instance.minimumEffortPath(new int[][] {{8,3,2,5,2,10,7,1,8,9},{1,4,9,1,10,2,4,10,3,5},{4,10,10,3,6,1,3,9,8,8},{4,4,6,10,10,10,2,10,8,8},{9,10,2,4,1,2,2,6,5,7},{2,9,2,6,1,4,7,6,10,9},{8,8,2,10,8,2,3,9,5,3},{2,10,9,3,5,1,7,4,5,6},{2,3,9,2,5,10,2,7,1,8},{9,10,4,10,7,4,9,3,1,6}});
	}

}
