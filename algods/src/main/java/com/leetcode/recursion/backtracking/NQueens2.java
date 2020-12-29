package com.leetcode.recursion.backtracking;
// TODO Anki
/* N Queens 2
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class NQueens2 {
	/* Backtracking - carry an ArrayList<> of columns to check canPlace(row,col,usedColsForEachRow)
	 * Time complexity : O(N!). 
	 * There is N possibilities to put the first queen, not more than N (N - 2) to put the second one, 
	 * not more than N(N - 2)(N - 4) for the third one etc. In total that results in O(N!) time complexity.
	 * Space complexity : O(N) to keep an information about columns.
	 * 
	 */
	int count=0;
	public int totalNQueens(int n) {
        if(n<2) return n;
        List<Integer> selectedColumns= new ArrayList<>();
        backtrack(0,selectedColumns,n);
        return count;
    }
	private void backtrack(int row, List<Integer> selectedColumns, int n) {
		if(row == n) {
			count+=1;
//			System.out.println("accepted: "+selectedColumns);
			return;
		}
		for(int col=0; col<n; col++) {
			if(canPlace(row,col,selectedColumns)) {
				selectedColumns.add(col);
				backtrack(row+1, selectedColumns, n);
				selectedColumns.remove(selectedColumns.size() -1);
			}
		}
	}
	private boolean canPlace(int row, int col, List<Integer> selectedColumns) {
//		System.out.println("---- "+row+" "+ col+ selectedColumns);
		for(int r=0; r< selectedColumns.size(); r++) {
			int placedRow=r, placedCol=selectedColumns.get(r);
//			System.out.println(placedRow+" "+placedCol+" "+(placedRow-row)+" "+(placedCol-col));
			if(placedCol == col || (Math.abs(placedRow-row) == Math.abs(placedCol-col))) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		assertEquals(0,new NQueens2().totalNQueens(0));
		assertEquals(1,new NQueens2().totalNQueens(1));
		assertEquals(0,new NQueens2().totalNQueens(2));
		assertEquals(2,new NQueens2().totalNQueens(4));
		assertEquals(10,new NQueens2().totalNQueens(5));
		assertEquals(4,new NQueens2().totalNQueens(6));
		assertEquals(40,new NQueens2().totalNQueens(7));
		assertEquals(92,new NQueens2().totalNQueens(8));
		assertEquals(352,new NQueens2().totalNQueens(9));
		System.out.println(new NQueens2().totalNQueens(5));
	}
}
