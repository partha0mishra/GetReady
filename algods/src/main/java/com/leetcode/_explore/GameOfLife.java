package com.leetcode._explore;
/**
 * Game of Life
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
Follow up:
Could you solve it in-place? Remember that the board needs to be updated simultaneously: 
You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. 
In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array 
(i.e., live cells reach the border). How would you address these problems?
 */
public class GameOfLife {
	// In place
	// O(M*N)/ O(1)
	// one pass for count, keeping counts based on orig value(0/1) and count of neighbors (0-8)
	// second pass is for decision based on origVal && count of neighbors
	//
	public void gameOfLife(int[][] board) {
		int m=board.length, n=board[0].length;
        // count pass
		int[][] dir= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
		for(int row=0; row< m; row++) {
			for(int col=0; col< n; col++) {
				int liveNeighbors=0;
				for(int[] d: dir) {
					int newR=row+d[0], newC=col+d[1];
					if(newR<0 || newC<0 || newR ==m || newC ==n) continue;// outside the board
					
					int nVal=board[newR][newC];
					if(nVal < 10) liveNeighbors+=nVal;// origVal is same
					else if(nVal < 20) liveNeighbors+=0;// origVal is 0
					else liveNeighbors+=1;// origVal is 1
				}
				board[row][col]=(1+board[row][col])*10+liveNeighbors;
			}
		}
//		printBoard(board);
		// decision pass
		for(int row=0; row<m; row++) {
			for(int col=0; col<n; col++) {
				int val=board[row][col], origVal=0;
				if(val >= 20) {
					val=val-20;
					origVal=1;
				}else val=val-10;
				
				if(val < 2 || val > 3) board[row][col]=0;
				else if(val ==3) board[row][col]=1;
				else board[row][col]=origVal;
			}
		}
    }
	public static void main(String[] args) {
		int[][] board1= {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		printBoard(board1);
		new GameOfLife().gameOfLife(board1);
		printBoard(board1);
		int[][] board2= {{1,1},{1,0}};
		printBoard(board2);
		new GameOfLife().gameOfLife(board2);
		printBoard(board2);
	}
	static void printBoard(int[][] board) {
		int rows=board.length, cols=board[0].length;
		for(int row=0; row< rows; row++) {
			for(int col=0; col< cols; col++) {
				System.out.printf("%3d", board[row][col]);
			}
			System.out.println();
		}
	}
}
