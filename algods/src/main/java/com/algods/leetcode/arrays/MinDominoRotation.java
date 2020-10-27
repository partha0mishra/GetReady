package com.algods.leetcode.arrays;
/* Minimum Domino Rotations For Equal Row
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:


Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Constraints:

2 <= A.length == B.length <= 2 * 10^4
1 <= A[i], B[i] <= 6
 */
public class MinDominoRotation {
	public int minDominoRotations(int[] A, int[] B) {
        int countAtoA0=0, countBtoA0=0, countAtoB0=0, countBtoB0=0;
        for(int i=1; i< A.length; i++) {// converting all A into A[0]
        			if(A[0] == A[i]) continue;
        	else 	if(A[0] == B[i]) countAtoA0+=1;
        	else 	{countAtoA0=Integer.MAX_VALUE; break;}
        }
        for(int i=0; i< B.length; i++) {// converting all B into A[0]
					if(A[0] == B[i]) continue;
			else 	if(A[0] == A[i]) countBtoA0+=1;
			else 	{countBtoA0=Integer.MAX_VALUE; break;}
		}
        for(int i=1; i< B.length; i++) {// converting all B into B[0]
					if(B[0] == B[i]) continue;
			else 	if(B[0] == A[i]) countBtoB0+=1;
			else 	{countBtoB0=Integer.MAX_VALUE; break;}
		}
		for(int i=0; i< A.length; i++) {// converting all A into B[0]
					if(B[0] == A[i]) continue;
			else 	if(B[0] == B[i]) countAtoB0+=1;
			else 	{countAtoB0=Integer.MAX_VALUE; break;}
		}
		if(countAtoA0 == Integer.MAX_VALUE && countBtoA0 == Integer.MAX_VALUE 
				&& countAtoB0 == Integer.MAX_VALUE && countBtoB0 == Integer.MAX_VALUE) return -1;
		else return Math.min(Math.min(countAtoA0, countBtoA0), Math.min(countAtoB0, countBtoB0));
    }
}
