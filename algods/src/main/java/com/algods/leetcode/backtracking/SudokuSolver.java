package com.algods.leetcode.backtracking;
/* Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [[Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
 */
import java.util.*;
public class SudokuSolver {
	public static final char EMPTY='.';
	char[][] newBoard;
	boolean solved=false;
	public void solveSudoku(char[][] board) {
		List<int[]> emptyCells= new ArrayList<>();
        for(int row=0; row< board.length; row++)
        	for(int col=0; col< board[0].length; col++)
        		if(board[row][col]==EMPTY) emptyCells.add(new int[] {row,col});
        backtrack(board,emptyCells,0);// original board, list of empty cells, starting index
        board=copyBoard(newBoard);
    }
	private char[][] copyBoard(char[][] board){
		char[][] copyBoard=new char[board.length][board[0].length];
		for(int row=0; row< board.length; row++)
        	for(int col=0; col< board[0].length; col++)
        		copyBoard[row][col]=board[row][col];
		return copyBoard;
	}
	private void backtrack(char[][] board, List<int[]> emptyCells, int index) {
//		if(solved) return;
		if(emptyCells.size()==index) {
			newBoard=copyBoard(board);
			solved=true;
			return;// solution found
		}
		int[] rowCol=emptyCells.get(index);
		for(int digit=1; digit<=9; digit++) {// trying each digit
			if(!solved && canPlace(board, rowCol, digit)) {
				board[rowCol[0]][rowCol[1]]=(char)(digit+'0');
				backtrack(board, emptyCells, index+1);
				if(solved) return;
				board[rowCol[0]][rowCol[1]]=EMPTY;
			}
		}
	}
	private boolean canPlace(char[][] board, int[] rowCol, int d) {
		char digit=(char)(d + '0');
		return(checkRow(board, rowCol[0], digit)
				&& checkCol(board, rowCol[1], digit)
				&& checkBlock(board, rowCol, digit));
	}
	private boolean checkRow(char[][] board, int row, char digit) {
		for(int col=0; col<9; col++) {
			if(board[row][col] == digit) return false;
		}
		return true;
	}
	private boolean checkCol(char[][] board, int col, char digit) {
		for(int row=0; row<9; row++) {
			if(board[row][col]==digit) return false;
		}
		return true;
	}
	private boolean checkBlock(char[][] board, int[] rowCol, char digit) {
		int row=rowCol[0], col=rowCol[1], startRow=getStart(row), startCol=getStart(col);
		for(int r=startRow; r< startRow+3; r++)
			for(int c=startCol; c< startCol+3; c++)
				if(board[r][c]==digit) return false;
		return true;
	}
	private int getStart(int rc) {
		if(rc < 3) return 0;
		if(rc < 6) return 3;
		return 6;
	}
	public static void main(String[] args) {
		char [][]board= {{'5','3','.','.','7','.','.','.','.'},
				         {'6','.','.','1','9','5','.','.','.'},
				         {'.','9','8','.','.','.','.','6','.'},
				         {'8','.','.','.','6','.','.','.','3'},
				         {'4','.','.','8','.','3','.','.','1'},
				         {'7','.','.','.','2','.','.','.','6'},
				         {'.','6','.','.','.','.','2','8','.'},
				         {'.','.','.','4','1','9','.','.','5'},
				         {'.','.','.','.','8','.','.','7','9'}};
		printBoard(board);
		new SudokuSolver().solveSudoku(board);
		printBoard(board);
	}
	public static void printBoard(char[][] board) {
		for(int i=0; i< board.length; i++) {
			System.out.println();
			for(int j=0; j< board[0].length; j++)
				System.out.printf("%2c ", board[i][j]);
		}
		System.out.println();
	}
}
