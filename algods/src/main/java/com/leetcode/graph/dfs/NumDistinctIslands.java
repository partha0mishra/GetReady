package com.leetcode.graph.dfs;
/**
 * 694. Number of Distinct Islands
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
 */
import java.util.*;

import javafx.util.Pair;
public class NumDistinctIslands {
	/**
	 * Approach 05:
	 * We can even just keep the directions U (up) D (down) L (left) R (right) in StringBuilder
	 * O(MN)/ O(MN) 
	 * 
	 * Performance-wise a little worse than calculating own hash function though :D
	 */
	public int numDistinctIslands(int[][] grid) {
        int rows=grid.length, cols=grid[0].length;
        Set<String> islandHashes= new HashSet<>();
        for(int r=0; r< rows; r++) {
        	for(int c=0; c< cols; c++) {
        		if(grid[r][c] == 1) {
        			StringBuilder island= new StringBuilder();
        			dfs(grid, r, c, island, 'o');// origin
        			islandHashes.add(island.toString());
        		}
        	}
        }
        return islandHashes.size();
    }
	private void dfs(int[][] grid, int row, int col, StringBuilder sb, char dir) {
		if(grid[row][col] == 0) return;
		sb.append(dir);
		grid[row][col]=0;// no more
		if(row < grid.length -1) 	dfs(grid, row+1, col, sb, 'd');// down
		if(col < grid[0].length -1) 	dfs(grid, row, col+1, sb, 'r');// right
		if(row > 0) 		dfs(grid, row-1, col, sb, 'u');// up
		if(col > 0)			dfs(grid, row, col-1, sb, 'l');// left
		sb.append('b');// back
	}
	/**
	 * Approach 04:
	 * Another way to take care of the hashing beast.
	 * just add the positions to a StringBuilder and put that into a HashSet
	 * O(MN)/ O(MN) 
	 * 
	 * Performance-wise a little worse than calculating own hash function though :D
	 */
//	public int numDistinctIslands(int[][] grid) {
//        int rows=grid.length, cols=grid[0].length;
//        Set<String> islandHashes= new HashSet<>();
//        for(int r=0; r< rows; r++) {
//        	for(int c=0; c< cols; c++) {
//        		if(grid[r][c] == 1) {
//        			StringBuilder island= new StringBuilder();
//        			dfs(grid, r, c, 0, 0, rows, cols, island);
//        			islandHashes.add(island.toString());
//        		}
//        	}
//        }
//        return islandHashes.size();
//    }
//	private void dfs(int[][] grid, int row, int col, int scoreR, int scoreC, int rows, int cols, StringBuilder sb) {
//		if(grid[row][col] == 0) return;
//		sb.append(scoreR+""+scoreC);
//		grid[row][col]=0;// no more
//		if(row < rows -1) 	dfs(grid, row+1, col, scoreR+1, scoreC, rows, cols, sb);
//		if(col < cols -1) 	dfs(grid, row, col+1, scoreR, scoreC+1, rows, cols, sb);
//		if(row > 0) 		dfs(grid, row-1, col, scoreR-1, scoreC, rows, cols, sb);
//		if(col > 0)			dfs(grid, row, col-1, scoreR, scoreC-1, rows, cols, sb);
//	}
	/**
	 * Approach 03:
	 * Set<Set<Pair<Integer,Integer>>> => Hashset <Islands>
	 * Island = Set<Pair<Integer, Integer>> => Set <Pairs>
	 * O(MN)/ O(MN) but more elegant using java HashSet<>
	 * 
	 * Performance-wise a little worse than calculating own hash function though :D
	 */
//	public int numDistinctIslands(int[][] grid) {
//        int rows=grid.length, cols=grid[0].length;
//        Set<Set<Pair<Integer,Integer>>> islandHashes= new HashSet<>();
//        for(int r=0; r< rows; r++) {
//        	for(int c=0; c< cols; c++) {
//        		if(grid[r][c] == 1) {
//        			Set<Pair<Integer,Integer>> island= new HashSet<>();
//        			dfs(grid, r, c, 50, 50, rows, cols, island);
//        			islandHashes.add(island);
//        		}
//        	}
//        }
//        return islandHashes.size();
//    }
//	private void dfs(int[][] grid, int row, int col, int scoreR, int scoreC, int rows, int cols, Set<Pair<Integer,Integer>> rcPairSet) {
//		if(grid[row][col] == 0) return;
//		rcPairSet.add(new Pair<>(scoreR, scoreC));
//		grid[row][col]=0;// no more
//		if(row < rows -1) 	dfs(grid, row+1, col, scoreR+1, scoreC, rows, cols, rcPairSet);
//		if(col < cols -1) 	dfs(grid, row, col+1, scoreR, scoreC+1, rows, cols, rcPairSet);
//		if(row > 0) 		dfs(grid, row-1, col, scoreR-1, scoreC, rows, cols, rcPairSet);
//		if(col > 0)			dfs(grid, row, col-1, scoreR, scoreC-1, rows, cols, rcPairSet);
//	}
//	/**
//	 * Approach 02: Optimized
//	 * O(MN)/ O(MN)
//	 */
//	public int numDistinctIslands(int[][] grid) {
//        int rows=grid.length, cols=grid[0].length;
//        HashSet<Integer> islandHashes= new HashSet<>();
//        for(int r=0; r< rows; r++) {
//        	for(int c=0; c< cols; c++) {
//        		if(grid[r][c] == 1) {
//        			List<int[]> rcList= new ArrayList<>();
//        			dfs(grid, r, c, 50, 50, rows, cols, rcList);
//        			int hashCode=0;
//        			for(int[] co: rcList) {
//        				hashCode+=(997*hashCode+10000*co[0]+co[1])%100000009;
//        			}
//        			islandHashes.add(hashCode);
//        		}
//        	}
//        }
//        return islandHashes.size();
//    }
//	private void dfs(int[][] grid, int row, int col, int scoreR, int scoreC, int rows, int cols, List<int[]> rcList) {
//		if(grid[row][col] == 0) return;
//		rcList.add(new int[]{scoreR, scoreC});
//		grid[row][col]=0;// no more
//		if(row < rows -1) 	dfs(grid, row+1, col, scoreR+1, scoreC, rows, cols, rcList);
//		if(col < cols -1) 	dfs(grid, row, col+1, scoreR, scoreC+1, rows, cols, rcList);
//		if(row > 0) 		dfs(grid, row-1, col, scoreR-1, scoreC, rows, cols, rcList);
//		if(col > 0)			dfs(grid, row, col-1, scoreR, scoreC-1, rows, cols, rcList);
//	}
	/**
	 * Approach 01: with coordinates - but should change as it doesn't need to be comparable
	 */
//	class Coordinates implements Comparable<Coordinates>{
//		int row, col;
//		public Coordinates(int r, int c) {this.row=r; this.col=c;}
//		public int compareTo(Coordinates o) {
//			int diff=Integer.compare(this.row, o.row);
//			return diff==0 ? Integer.compare(this.col, o.col): diff; 
//		}
//	}
//	public int numDistinctIslands(int[][] grid) {
//        int rows=grid.length, cols=grid[0].length;
//        HashSet<Integer> islandHashes= new HashSet<>();
//        for(int r=0; r< rows; r++) {
//        	for(int c=0; c< cols; c++) {
//        		if(grid[r][c] == 1) {
//        			List<Coordinates> rcList= new ArrayList<>();
//        			dfs(grid, r, c, 50, 50, rows, cols, rcList);
////        			Collections.sort(rcList);
////        			islandHashes.add(Objects.hashCode(rcList));// starting the score at 0,50
//        			int hashCode=0;
//        			for(Coordinates co: rcList) {
//        				hashCode+=(997*hashCode+10000*co.row+co.col)%100000009;
//        			}
//        			islandHashes.add(hashCode);
//        		}
//        	}
//        }
////        for(int r=0; r<rows; r++) {
////        	for(int c=0; c< cols; c++) {
////        		System.out.printf("%2d",grid[r][c]);
////        		if(grid[r][c] !=0) break;
////        	}
////        	System.out.println();
////        }
//        return islandHashes.size();
//    }
//	private void dfs(int[][] grid, int row, int col, int scoreR, int scoreC, int rows, int cols, List<Coordinates> rcList) {
//		if(grid[row][col] == 0) return;
//		rcList.add(new Coordinates(scoreR,scoreC));
//		grid[row][col]=0;// no more
//		if(row < rows -1) 	dfs(grid, row+1, col, scoreR+1, scoreC, rows, cols, rcList);
//		if(col < cols -1) 	dfs(grid, row, col+1, scoreR, scoreC+1, rows, cols, rcList);
//		if(row > 0) 		dfs(grid, row-1, col, scoreR-1, scoreC, rows, cols, rcList);
//		if(col > 0)			dfs(grid, row, col-1, scoreR, scoreC-1, rows, cols, rcList);
//	}
	public static void main(String[] args) {
		NumDistinctIslands ndi= new NumDistinctIslands();
		int[][] grid= {{1,0,1,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,0,1,1,0,0,0,0,1,1,0,1,1,1,0,1,0,1,0,0,0,1,0,0,1,1,1,1,0,0},{1,0,1,1,1,0,1,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,0,0,1,0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,1,1,0,1,0,1,0,1,1},{1,1,0,0,0,1,0,1,1,0,1,0,1,1,1,0,0,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,0,0,1,1,0,1,0,0,1,0,0},{0,0,1,1,0,0,1,1,1,1,1,1,0,1,0,0,1,0,0,1,0,1,0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,1,1,0,1,1,0,0},{1,1,1,1,0,0,1,0,0,1,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,1,0,1,1,1,0,0,0,1,0,1,0,0,1,0,1,1,0,0,1,0,1,1,0},{1,1,1,0,1,1,0,1,1,0,0,1,0,1,1,0,1,0,0,0,1,0,1,1,0,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,1,1,0,0,1},{1,0,1,0,1,1,0,1,0,0,1,1,1,0,1,0,0,1,0,0,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,1,0,1,1,1,1,0},{1,1,0,0,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,0,1,1,0,1,1,0,0,1,1,1,1,1,1,0,0,1,0,1,0,1,0},{1,1,0,1,0,0,1,1,0,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,0,1,1,1,1,0,0,1,0,1},{1,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,1,1,1,1,0,0,1,0,0,1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,1,0,0,0,1,1,1,0,1,0},{1,1,1,0,0,0,0,0,1,0,1,1,1,1,1,0,0,0,0,1,0,0,1,0,0,0,1,0,1,1,1,0,1,1,0,1,0,0,0,1,1,0,0,1,0,1,1,1,1,0},{1,1,1,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,1,1,1,1,1,0,1,0,1,1,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,1,1,0,1,0,1,1,0,1,1,1,0,0,1,0,1,0,0,1,1,0,0,1,1,1,0,1,1,0,1,1,0,0,1,0,1,0,1},{0,0,1,0,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,0,0,1,0,0,1,0,0,1,1},{0,0,1,1,0,1,0,1,1,1,1,0,0,0,0,0,0,1,0,1,0,1,1,1,1,1,1,0,0,1,0,1,0,1,1,0,1,1,0,1,0,1,1,1,0,0,0,0,0,1},{1,0,0,1,1,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,0,0,0,1,0,1,0,1,1,0,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1},{1,0,0,0,0,1,0,1,0,1,1,0,0,0,1,0,1,1,1,1,0,1,1,1,0,1,1,0,1,1,0,0,0,0,0,0,1,0,1,1,0,0,1,0,0,0,0,0,1,1},{0,1,1,0,0,0,0,0,1,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,1,0,1,0,0,0,1,1,0,1,0,1,0,0,1,1,1,1,0,0,1,1,1,0,1,0},{1,0,0,0,1,0,1,1,0,1,0,1,0,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1},{0,1,1,0,0,1,0,1,1,0,0,1,0,1,1,0,1,1,0,0,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,1,0,0,1,1,0,1,1,0,1,0,0,1,1},{1,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,0,1},{1,1,0,1,0,1,1,0,0,0,0,0,0,0,1,1,1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,1,1,0,1,1,0,1,0,0,0},{1,0,1,1,0,1,1,1,1,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,0},{1,0,0,1,0,0,0,1,0,1,0,0,1,1,0,0,1,1,0,0,0,0,1,0,1,1,0,1,0,0,0,0,0,1,0,1,1,1,1,1,0,0,1,1,0,0,1,0,1,0},{1,1,1,1,0,0,1,0,0,0,0,1,1,1,1,1,0,0,1,0,1,0,0,1,1,1,0,1,0,1,1,0,0,1,0,0,0,1,1,1,0,1,0,0,0,0,0,0,1,1},{0,1,1,0,0,0,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,0,1,0,0,1,1,1,1,1,0,1,1,1,0,0,0,0},{0,1,1,1,1,1,1,0,1,0,1,1,1,1,0,0,0,0,0,0,0,1,0,0,1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,1,1},{1,1,1,1,1,0,0,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,1,0,1,1,0,1,1,1,0,0,0,0,0,0},{1,0,0,0,1,0,0,0,0,1,0,1,0,1,0,0,1,0,1,1,1,1,1,0,0,0,1,0,1,0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1},{0,0,1,0,1,1,0,1,1,0,0,0,1,0,1,0,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0},{0,1,1,1,0,0,1,0,1,1,1,0,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,1,1,1},{0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,0,0,1,1,1,0,1,0,0,1,1,1,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,0,1},{0,0,0,1,0,0,0,1,1,1,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,0,1,0,0,0,1,1,1,1,1,0,1,1,1,0,0},{0,1,0,0,1,0,0,0,1,0,0,1,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,0,0,1},{0,1,1,1,0,0,1,1,1,0,1,1,1,1,0,1,0,1,0,1,1,0,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,0,0,1,0,0,0,1,1,1},{1,0,0,1,1,0,0,1,0,1,1,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,1,1,1,0,1,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,0},{0,1,0,1,1,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0,1,0,0,1,1,0,1,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,1,0,0},{1,0,1,1,1,0,0,0,1,1,0,1,0,1,0,0,1,1,0,1,0,0,0,1,0,1,1,1,0,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1,0,1,1,0,1,0},{1,0,1,1,1,1,0,0,0,1,1,1,1,0,1,0,1,1,0,1,1,1,1,1,0,0,1,1,0,1,0,1,0,0,0,0,1,0,1,1,1,0,0,0,1,0,1,1,0,1},{0,1,1,0,1,1,1,1,0,0,0,0,1,1,0,1,0,1,0,1,1,1,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,0,0,1,1,0,1,1,1,0,0,0,1,1},{1,1,1,1,0,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,1,0,0,1,1,1,1,1,0,0,1,0,0,1,0},{0,0,1,0,0,0,1,1,1,1,1,0,0,1,0,0,0,1,1,0,1,0,0,0,1,1,0,0,1,0,0,0,1,1,0,0,1,0,1,1,1,0,1,0,0,1,1,1,1,1},{1,0,1,1,0,0,0,0,0,0,1,0,1,0,0,0,1,0,1,1,1,0,1,1,0,0,1,1,1,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,0,0,1,1,0,1},{0,1,0,0,1,0,0,1,1,1,1,1,0,1,1,1,0,0,0,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1},{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1,0,0,0,1,0,1,0,1,1,0,0,0,1,1,0,1,0,0,0,1,0,0,1,0,1,1,0,1},{0,0,0,0,1,0,1,1,0,1,1,1,0,0,0,1,1,0,0,1,0,0,1,1,0,0,0,1,0,1,1,0,1,0,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1},{0,1,0,0,1,1,0,1,0,1,0,0,0,0,1,1,1,0,0,1,0,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,0,1,1},{0,0,0,1,0,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,0,1,1,0,0,0,0,1,1,0,1,1,0,1,1,1,1,1,0,0,1,1,0,1,0,0,1,1,0,0},{0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,1,0,1,0,0,0,1,1,0,0,1,0,0,1,0,1,0,0,1,0,0,0,1,0,0,0,1},{1,0,1,0,1,1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,0,1,0,0,1,0,1,1,1,0,1,1,0,1,1,0,0,1}};
		System.out.println(ndi.numDistinctIslands(grid));// 66
	}

}
