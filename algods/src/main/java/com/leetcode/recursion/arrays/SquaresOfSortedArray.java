package com.leetcode.recursion.arrays;
/* 977. Squares of a Sorted Array
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
 * */
import java.util.Arrays;
public class SquaresOfSortedArray {
	/* Approach 02: O(n) - no sorting */
	public int[] sortedSquares(int[] A) {
		int[] result=new int[A.length];
		int l=0, r=A.length-1, left, right, pos=A.length-1;
		while(l <= r) {
            System.out.println(pos);
			left=Math.abs(A[l]);
			right=Math.abs(A[r]);
			if(left > right) {
				result[pos]=A[l]*A[l];
				l++;
			}else {
				result[pos]=A[r]*A[r];
				r--;
			}
            pos--;
		}
		return result;
	}
	/* Approach 01: O(nLogn) using Arrays.sort()*/
//	public int[] sortedSquares(int[] A) {
//        for(int i=0; i< A.length; i++){
//            A[i]*=A[i];
//        }
//        Arrays.sort(A);
//        return A;
//    }
}
