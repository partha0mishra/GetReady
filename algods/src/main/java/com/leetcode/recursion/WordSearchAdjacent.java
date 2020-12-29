package com.leetcode.recursion;

import java.util.HashSet;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearchAdjacent {
	char[][] b;
	int min_row=-1;
	int min_col=-1;
	int max_row;
	int max_col;
	String w;
	HashSet<Integer> used;
	
	public boolean exist(char[][] board, String word) {
		if(board == null || word == null) return false;
		b=board;
		max_row=b.length;
		max_col=b[0].length;
		if(max_row ==0 || max_col ==0 || word.length() ==0) return false;
		w=word;
		used=new HashSet<Integer>();
		boolean found=false;
		int i=0;
		for(int row=0; row< max_row; row++) {
			for(int col=0; col< max_col; col++) {
//				System.out.print(b[row][col]);
				found=findAdjacent(row,col,i);
				if(found) return true;
			}
//			System.out.println();
		}
		
        return found;
    }
	private boolean findAdjacent(int row, int col, int i) {
		if(i == w.length()) return true;// found already
		char c= w.charAt(i);
		if(row == min_row || col == min_col
				|| row == max_row || col == max_col || used.contains(1000*row+col) || b[row][col] != c) {
			return false;
		}// boundary condition of row, col, used, no-match	
		boolean found=false;
		// matched here
		used.add(1000*row+col);
		i=i+1;
		
		found= findAdjacent(row-1,col,i);
		if(!found) found= findAdjacent(row+1,col,i);
		if(!found) found= findAdjacent(row,col-1,i);
		if(!found) found= findAdjacent(row,col+1,i);
		
		if(!found) used.remove(1000*row+col);
		return found;
	}
	
	public static void main(String[] args) {
		char [][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		char [][] emptyBoard = {{}};
		System.out.println(new WordSearchAdjacent().exist(board,"ABCCED")+" true");// true
		System.out.println(new WordSearchAdjacent().exist(board,"SEE")+" true");// true
		System.out.println(new WordSearchAdjacent().exist(board,"ABCB")+" false");// false
		System.out.println(new WordSearchAdjacent().exist(null,"ABCCED")+" false");// false
		System.out.println(new WordSearchAdjacent().exist(emptyBoard,"ABCCED")+" false");// false
		System.out.println(new WordSearchAdjacent().exist(board,"A")+" true");// true
		System.out.println(new WordSearchAdjacent().exist(board,"ABFDA")+" true");// true
		System.out.println(new WordSearchAdjacent().exist(board,"ABFDAS")+" true");// true
		System.out.println(new WordSearchAdjacent().exist(board,"ABFDASA")+" false");// false
		System.out.println(new WordSearchAdjacent().exist(board,"")+" false");// false
		
		// good one to test whether the tracking indicator is getting reset
		char[][] board2= {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
		System.out.println(new WordSearchAdjacent().exist(board2,"AAB")+" true");// true
	}

}
