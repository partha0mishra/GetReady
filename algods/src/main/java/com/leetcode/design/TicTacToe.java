package com.leetcode.design;

public class TicTacToe {
	int[][] board;
	int won, size;
	/** Initialize your data structure here. */
    public TicTacToe(int n) {
        board=new int[n][n];
        size=n;
        won=0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(won !=0) return won;
        board[row][col]=player;
        printBoard();
        if(wins(row,col,player)) won=player;
        return won;
    }
    // Approach 02: less checking 
    // check the col from row 0 to size-1 and then row from col 0 to size -1
    // check the corners if row==col
    private boolean wins(int row, int col, int player) {
    	int r, c;
    	for(r=0; r< size; r++) if(board[r][col] != player) break;// check the column
    	if(r==size) return true;
    	for(c=0; c< size; c++) if(board[row][c] != player) break;// check the row
    	if(c==size) return true;
		for(r=0, c=0; r<size; r++, c++) if(board[r][c] != player) break;// top left - bottom right corner
		if(r == size) return true;
		for(r=size-1, c=0; c< size; r--, c++) if(board[r][c] != player) break;// bottom left - top right corner
		if(c == size) return true;
    	return false;
    }
    
    // Approach 01: Brute - checking all related to this coordinate
//    int[][][] dirs= {{{1,1},{-1,-1}}, // left up to right bottom corner-wise
//			{{-1,1},{1,-1}},{{0,1},{0,-1}},{{1,0},{-1,0}}};// other corner, horizontal, vertical
//    private boolean wins(int row, int col, int player) {
//    	for(int[][] dir: dirs) {
//    		if(grow(row, col, player, dir)) return true;
//    	}
//    	return false;
//    }
//	
//	private boolean grow(int row, int col, int player, int[][] dir) {
//		int matches=1;// board[row][col] is of the right mark to start with
//		for(int[] d: dir) {
//			int ri=d[0], ci=d[1];// row increment, col increment
//			while(row+ri >= 0 && col+ci >= 0 && row+ri < size && col+ci < size && board[row+ri][col+ci] == player && matches < size) {
//				matches+=1;
//				ri+=d[0];
//				ci+=d[1];
//			}
//		}
//		
//		return matches==size;
//	}

	private void printBoard() {
		System.out.println("------------");
		for(int i=0; i< size; i++){
			for(int j=0; j< size; j++) {
				System.out.printf("%3d", board[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
//		TicTacToe ttt= new TicTacToe(3);
//		System.out.println(ttt.move(0, 0, 1));
//		System.out.println(ttt.move(0, 2, 2));
//		System.out.println(ttt.move(2, 2, 1));
//		System.out.println(ttt.move(1, 1, 2));
//		System.out.println(ttt.move(2, 0, 1));
//		System.out.println(ttt.move(1, 0, 2));
////		System.out.println(ttt.move(2, 1, 1));// 1 wins . it won't even let other put a move
//		System.out.println(ttt.move(0, 1, 1));// stupid move trying for a 2 win
//		System.out.println(ttt.move(1, 2, 2));// 2 wins
//		TicTacToe t2= new TicTacToe(2);
//		System.out.println(t2.move(0, 0, 2));
//		System.out.println(t2.move(1, 1, 1));
//		System.out.println(t2.move(0, 1, 2));
		TicTacToe t201= new TicTacToe(2);
		System.out.println(t201.move(0, 1, 1));
		System.out.println(t201.move(1, 1, 2));
		System.out.println(t201.move(1, 0, 1));
	}
}
