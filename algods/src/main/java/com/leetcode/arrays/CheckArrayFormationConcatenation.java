package com.leetcode.arrays;
/** TODO Anki
 * 1640. Check Array Formation Through Concatenation
 * You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.

 

Example 1:

Input: arr = [85], pieces = [[85]]
Output: true
Example 2:

Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]
Example 3:

Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].
Example 4:

Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
Output: true
Explanation: Concatenate [91] then [4,64] then [78]
Example 5:

Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
Output: false
 

Constraints:

1 <= pieces.length <= arr.length <= 100
sum(pieces[i].length) == arr.length
1 <= pieces[i].length <= arr.length
1 <= arr[i], pieces[i][j] <= 100
The integers in arr are distinct.
The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers in this array are distinct).
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class CheckArrayFormationConcatenation {
	public boolean canFormArray(int[] arr, int[][] pieces) {
        for(int[] piece: pieces) {// let's check every piece
        	int i, j;// i iterates on the arr, j on a piece
        	boolean found=false;// if the first element of the piece is not found
        	for(i=0,j=0; i< arr.length && j < piece.length; i++) {// we are tracking J, if i is over but J is not
        		if(arr[i] == piece[j]) {// if the first element is found we ..
        			found=true;
        			if(j != piece.length) {// need to find the other ones too
        				j+=1;
        			}else break;// this piece is found. let's find the next one
        		}else {
        			if(found == true) return false;// some initial elements WERE found and subsequently nada
        			found=false;
        		}
        	}
        	if(!found || j< piece.length) return false;
        }
        return true;// only when all the pieces are found
    }
	public static void main(String[] args) {
		CheckArrayFormationConcatenation cafc= new CheckArrayFormationConcatenation();
		assertTrue(cafc.canFormArray(new int[] {85}, new int[][] {{85}}));
		assertTrue(cafc.canFormArray(new int[] {15,88}, new int[][] {{88},{15}}));
		assertFalse(cafc.canFormArray(new int[] {49,18,16}, new int[][] {{16,18,49}}));
		assertTrue(cafc.canFormArray(new int[] {91,4,64,78}, new int[][] {{78},{4,64},{91}}));
		assertFalse(cafc.canFormArray(new int[] {1,3,5,7}, new int[][] {{2,4,6,8}}));
	}

}
