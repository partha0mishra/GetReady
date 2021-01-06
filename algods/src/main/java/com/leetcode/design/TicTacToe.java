package com.leetcode.design;
/** TODO Anki
 * Design Tic Tac Toe
 * Assume the following rules are for the tic-tac-toe game on an n x n board between two players:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves are allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Implement the TicTacToe class:

TicTacToe(int n) Initializes the object the size of the board n.
int move(int row, int col, int player) Indicates that player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move.
Follow up:
Could you do better than O(n2) per move() operation?

 

Example 1:

Input
["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
[[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
Output
[null, 0, 0, 0, 0, 0, 0, 1]

Explanation
TicTacToe ticTacToe = new TicTacToe(3);
Assume that player 1 is "X" and player 2 is "O" in the board.
ticTacToe.move(0, 0, 1); // return 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

ticTacToe.move(0, 2, 2); // return 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

ticTacToe.move(2, 2, 1); // return 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

ticTacToe.move(1, 1, 2); // return 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

ticTacToe.move(2, 0, 1); // return 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

ticTacToe.move(1, 0, 2); // return 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

ticTacToe.move(2, 1, 1); // return 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
 

Constraints:

2 <= n <= 100
player is 1 or 2.
1 <= row, col <= n
(row, col) are unique for each different call to move.
At most n2 calls will be made to move.
 */
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
    // Approach 02: less checking - 100% runtime
    // check the col from row 0 to size-1 and then row from col 0 to size -1
    // check the corners if row==col - NOPE. that's wrong.
    private boolean wins(int row, int col, int player) {
    	int r, c;
    	for(r=0; r< size; r++) if(board[r][col] != player) break;// check the column
    	if(r==size) return true;
    	for(c=0; c< size; c++) if(board[row][c] != player) break;// check the row
    	if(c==size) return true;
    	if(row == col) {// top left - bottom right corner
    		for(r=0, c=0; r<size; r++, c++) if(board[r][c] != player) break;
    		if(r == size) return true;
    	}
    	if( size-1-row == col) {// bottom left - top right corner
    		for(r=size-1, c=0; c< size; r--, c++) if(board[r][c] != player) break;
    		if(c == size) return true;
    	}
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
