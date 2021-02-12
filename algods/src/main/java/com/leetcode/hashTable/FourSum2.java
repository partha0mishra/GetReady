package com.leetcode.hashTable;
/**
 * 454. 4sum II
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) 
 * there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. 
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
import java.util.HashMap;
import java.util.Iterator;
public class FourSum2 {
	/* Approach 01: Brute force O(n2) O(n2) */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Long,Integer> cdhm=new HashMap<>();
        HashMap<Long,Integer> abhm=new HashMap<>();
        for(int c=0; c< C.length; c++)
        	for(int d=0; d< D.length; d++) {
        		long key=-1* ((long)C[c]+(long)D[d]);
        		cdhm.put(key, cdhm.getOrDefault(key, 0)+1);
        	}
        
        for(int a=0; a< A.length; a++)
        	for(int b=0; b< B.length; b++) {
        		long key=(long)A[a]+(long)B[b];
        		abhm.put(key, abhm.getOrDefault(key, 0)+1);
        	}
        int count=0;
        
        Iterator<Long> it=abhm.keySet().iterator();
        while(it.hasNext()) {
        	long ab=it.next();
        	count+=abhm.get(ab) * cdhm.getOrDefault(ab, 0);
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
